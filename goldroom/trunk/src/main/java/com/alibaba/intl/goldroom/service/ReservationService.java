package com.alibaba.intl.goldroom.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.goldroom.dao.BookItemDao;
import com.alibaba.intl.goldroom.dao.IntegralDao;
import com.alibaba.intl.goldroom.dao.MemberDao;
import com.alibaba.intl.goldroom.dao.ReservationDao;
import com.alibaba.intl.goldroom.dataobject.BookItem;
import com.alibaba.intl.goldroom.dataobject.Integral;
import com.alibaba.intl.goldroom.dataobject.Member;
import com.alibaba.intl.goldroom.dataobject.Reservation;
import com.alibaba.intl.goldroom.result.ReservationResult;

@Service
@RemotingDestination
@Transactional
public class ReservationService {

    private static Logger   logger = Logger.getLogger(ReservationService.class);

    @Autowired
    private BookItemDao     bookItemDao;

    @Autowired
    private ReservationDao  reservationDao;

    @Autowired
    private MemberDao       memberDao;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private IntegralDao     integralDao;

    public ReservationResult listReservatedBooksBySubscriber(String loginId, int page, int pagesize) {
        int totalCount = reservationDao.countByLogindId(loginId);
        List<Reservation> reservationList = reservationDao.listByLoginId(loginId, page, pagesize);
        return new ReservationResult(reservationList, totalCount);
    }

    public ReservationResult listReservationByBookItemId(Integer bookItemId){
        int totalCount = reservationDao.countByBookItemId(bookItemId);
        List<Reservation> reservationList = reservationDao.listByBookItemId(bookItemId);
        return new ReservationResult(reservationList, totalCount);
    }
    public boolean reserve(String subscriberLoginId, int bookItemId, Date lendTime, Date returnTime) {
        BookItem item = bookItemDao.findById(bookItemId);
        if (item.getMember().getLoginId().equals(subscriberLoginId)) {
            // 不能预约自已的书
            return false;
        }
        if (BookItemStateEnum.IDLE.equalsState(item.getState())) {
            if (reservationDao.updateStateByBookItemId(bookItemId, Reservation.STATE_TO_BE_COMFIRM) == false) {
                Member subcriber = memberDao.findByLoginId(subscriberLoginId);
                Reservation reservation = new Reservation();
                // reservation.setOwner(item.getMember());
                reservation.setLendTime(lendTime);
                reservation.setReturnTime(returnTime);
                reservation.setBookItem(item);
                reservation.setSubscriber(subcriber);
                reservation.setState(Reservation.STATE_TO_BE_COMFIRM);
                reservationDao.save(reservation);

                logger.info("[Reservation success]" + reservation.getId());

                // 发送邮件
                EmailInfo emailInfo = new EmailInfo(ServiceType.RESERVATION);
                emailInfo.setOwner(item.getMember());
                emailInfo.setBorrower(subcriber);
                emailInfo.setBookInfo(item.getBookInfo());
                emailInfo.setReservation(reservation);
                emailInfo.addReceiverEmail(item.getMember().getEmail());
                sendMailService.sendMail(emailInfo);
            }
            // 书籍被预约
            Integral integral = integralDao.findByLoginId(item.getMember().getLoginId());
            if (integral != null) {
                integral.setValue(integral.getValue() + 50);
                integralDao.updateByLoginId(integral);
            }

            item.setState(BookItemStateEnum.RESERVATED.getValue());
            bookItemDao.updateById(item);
            return true;
        } else {
            logger.info("[Reservation failed]");
            return false;
        }
    }
}

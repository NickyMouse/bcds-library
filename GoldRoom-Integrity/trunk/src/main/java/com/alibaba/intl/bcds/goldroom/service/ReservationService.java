package com.alibaba.intl.bcds.goldroom.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.constaints.RoleEnum;
import com.alibaba.intl.bcds.goldroom.dao.BookItemDao;
import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dao.MemberDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDao;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.result.ReservationResult;

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
    private LendingDao      lendingDao;

    public ReservationResult listReservatedBooksBySubscriber(String loginId, int page, int pagesize) {
        int totalCount = reservationDao.countByLogindId(loginId);
        List<Reservation> reservationList = reservationDao.listByLoginId(loginId, page, pagesize);
        return new ReservationResult(reservationList, totalCount);
    }

    public ReservationResult listReservationByBookItemId(Integer bookItemId) {
        int totalCount = reservationDao.countByBookItemId(bookItemId);
        List<Reservation> reservationList = reservationDao.listByBookItemId(bookItemId);
        return new ReservationResult(reservationList, totalCount);
    }

    public boolean deleteReservation(Integer reservationId) {
        Reservation r = reservationDao.findById(reservationId);
        if (r == null) {
            return false;
        }
        if (Reservation.STATE_REJECT.equals(r.getState())) {
            reservationDao.deleteReservation(reservationId);
            return true;
        } else if (Reservation.STATE_TO_BE_COMFIRM.equals(r.getState())) {
            BookItem bookItem = r.getBookItem();
            bookItem.setState(BookItemStateEnum.IDLE.getValue());
            if (bookItemDao.updateBookItemState(bookItem)) {
                if (reservationDao.deleteReservation(reservationId)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean reserve(String subscriberLoginId, int bookItemId, Date lendTime, Date returnTime) {
        BookItem item = bookItemDao.findById(bookItemId);
        Member bookOwner = item != null && item.getOwner() != null ? item.getOwner():null; // by Harrison
        
        if (bookOwner != null && bookOwner.getLoginId().equals(subscriberLoginId)) {
            // 不能预约自已的书
            return false;
        }
        if (BookItemStateEnum.IDLE.equalsState(item.getState())) {

            if (RoleEnum.ROLE_LIBRARY.getName().equals(bookOwner.getRole())) {
                // 借阅图书管的书籍
                Member subcriber = memberDao.findByLoginId(subscriberLoginId);
                Lending lending = new Lending();
                lending.setBookItem(item);
                lending.setReturnTime(returnTime);
                lending.setSubscriber(subcriber);
                lending.setLendTime(lendTime);

                lendingDao.save(lending);
                item.setState(BookItemStateEnum.LENDED.getValue());
                bookItemDao.updateBookItemState(item);

                EmailInfo emailInfo = new EmailInfo(ServiceType.GET_BOOK);
                emailInfo.setOwner(bookOwner);
                emailInfo.setBorrower(lending.getSubscriber());
                emailInfo.setBookInfo(item.getBookInfo());
                emailInfo.setLending(lending);
                emailInfo.addReceiverEmail(lending.getSubscriber().getEmail());
                sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
                logger.info("[Lend book success]" + lending.getId());
                return true;
            } else {
                // 借阅其他用户的书
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

                    // 发�?邮件
                    EmailInfo emailInfo = new EmailInfo(ServiceType.RESERVATION);
                    emailInfo.setOwner(bookOwner);
                    emailInfo.setBorrower(subcriber);
                    emailInfo.setBookInfo(item.getBookInfo());
                    emailInfo.setReservation(reservation);
                    emailInfo.addReceiverEmail(bookOwner.getEmail());
                    sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
                }
                // 书籍被预定
                
                /* -- update the bookItem owner's score , by Harrison -- */
                bookOwner.setScore(bookOwner.getScore() == null || bookOwner.getScore() == 0 ? 50: bookOwner.getScore() + 50);
                memberDao.updateMemberByLoginId(bookOwner); 
                /* -- end -- */
                
                item.setState(BookItemStateEnum.RESERVATED.getValue());
                bookItemDao.updateById(item);
                return true;
            }
        } else {
            logger.info("[Reservation failed]");
            return false;
        }
    }
}

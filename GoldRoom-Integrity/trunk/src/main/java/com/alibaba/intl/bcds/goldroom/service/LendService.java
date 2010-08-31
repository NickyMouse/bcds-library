package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
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
import com.alibaba.intl.bcds.goldroom.result.LendingResult;

@Transactional
public class LendService {

    private static Logger   logger = Logger.getLogger(LendService.class);

    @Autowired
    private BookItemDao     bookItemDao;

    @Autowired
    private ReservationDao  reservationDao;

    @Autowired
    private LendingDao      lendingDao;

    @Autowired
    private SendMailService sendMailService;
    
    @Autowired
    private MemberDao memberDao; //by Harrison for refactoried member entity

    public LendingResult listLendedBookItemBySubscriber(String ownerLoginID, int page, int pagesize) {
        int totalCount = lendingDao.countByLogindId(ownerLoginID);
        List<Lending> itemList = lendingDao.listByLoginId(ownerLoginID, page, pagesize);
        return new LendingResult(itemList, totalCount);
    }

    public LendingResult listLendingByBookItemId(Integer bookItemId){
        int totalCount = lendingDao.countByBookItemId(bookItemId);
        List<Lending> itemList = lendingDao.listByBookItemId(bookItemId);
        return new LendingResult(itemList, totalCount);
    }

    public boolean lend(int reservationId, String currentUser) {
        Reservation reservation = reservationDao.findById(reservationId);
        BookItem bookItem = reservation.getBookItem();
        Member bookOwner = bookItem != null && bookItem.getOwner() != null ? bookItem.getOwner():null; // by Harrison
        if (bookOwner != null && !bookOwner.getLoginId().equals(currentUser)) {
            // 如果书的主人跟登录用户不一致
            return false;
        }
        if (BookItemStateEnum.RESERVATED.equalsState(bookItem.getState())) {

            Lending lending = new Lending();
            lending.setBookItem(reservation.getBookItem());
            lending.setReturnTime(reservation.getReturnTime());
            lending.setSubscriber(reservation.getSubscriber());
            lending.setLendTime(reservation.getLendTime());

            /* ---- update the member's score, by Harrison --*/
            bookOwner.setScore(bookOwner.getScore() == null || bookOwner.getScore()== 0 ? 50:bookOwner.getScore()+50);
            memberDao.save(bookOwner);
            /* -- end -- */
            
            lendingDao.save(lending);
            bookItem.setState(BookItemStateEnum.LENDED.getValue());
            bookItemDao.updateBookItemState(bookItem);
            reservationDao.cutReservationToLog(reservation);

           
            // 发邮件
            EmailInfo emailInfo = new EmailInfo(ServiceType.GET_BOOK);
            emailInfo.setOwner(bookOwner);
            emailInfo.setBorrower(lending.getSubscriber());
            emailInfo.setBookInfo(bookItem.getBookInfo());
            emailInfo.setLending(lending);
            emailInfo.addReceiverEmail(lending.getSubscriber().getEmail());
            sendMailService.sendVelocityMail(emailInfo, null, null, null, null);
            logger.info("[Lend book success]" + lending.getId());
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(int lendId, String currentUser) {
        Lending lending = lendingDao.findById(lendId);
        BookItem bookItem = bookItemDao.findById(lending.getBookItem().getId());
        Member bookOwner = bookItem != null && bookItem.getOwner() != null ? bookItem.getOwner():null; // by Harrison
        if (bookOwner != null && !bookOwner.getLoginId().equals(currentUser)) {
            return false;
        }
        lendingDao.updateRealReturnTime(lendId);
        lendingDao.cutLendingToLog(lending);
        bookItem.setState(BookItemStateEnum.IDLE.getValue());
        bookItemDao.updateBookItemState(bookItem);

        EmailInfo emailInfo = new EmailInfo(ServiceType.CONFIRM_RETURN_BOOK);
        emailInfo.setOwner(bookOwner);
        emailInfo.setBorrower(lending.getSubscriber());
        emailInfo.setBookInfo(bookItem.getBookInfo());
        emailInfo.setLending(lending);
        emailInfo.addReceiverEmail(lending.getSubscriber().getEmail());
        sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
        return true;
    }

    public boolean rejectLend(int reservationId, String currentUser) {
        Reservation reservation = reservationDao.findById(reservationId);
        if (reservation != null) {
            BookItem bookItem = reservation.getBookItem();
            Member bookOwner = bookItem != null && bookItem.getOwner() != null ? bookItem.getOwner() : null; // by Harrison

            // 如果书的主人跟登录用户不在线或该书不在预约状态
            if (bookItem == null || bookOwner == null || !bookOwner.getLoginId().equals(currentUser)
                || !BookItemStateEnum.RESERVATED.equalsState(bookItem.getState())) {
                return false;
            }
            reservationDao.updateStateByBookItemId(bookItem.getId(), Reservation.STATE_REJECT);
            bookItem.setState(BookItemStateEnum.IDLE.getValue());
            bookItemDao.updateById(bookItem);

            EmailInfo emailInfo = new EmailInfo(ServiceType.REJECT_LEND_BOOK);
            emailInfo.setOwner(bookOwner);
            emailInfo.setBorrower(reservation.getSubscriber());
            emailInfo.setBookInfo(bookItem.getBookInfo());
            emailInfo.setReservation(reservation);
            emailInfo.addReceiverEmail(reservation.getSubscriber().getEmail());
            sendMailService.sendVelocityMail(emailInfo, null, null, null,null);
        }
        return true;
    }
}

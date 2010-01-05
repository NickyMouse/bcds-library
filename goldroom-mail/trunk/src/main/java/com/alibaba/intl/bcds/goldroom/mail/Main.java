package com.alibaba.intl.bcds.goldroom.mail;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.LendingWithExpireDays;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.dao.MailDao;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.impl.SendMailServiceImpl;
import com.alibaba.intl.bcds.goldroom.mail.utils.MailApplicationContext;

public class Main {

    private static Logger              logger      = Logger.getLogger(Main.class);
    private static int                 PAGE_SIZE   = 50;
    private static SendMailServiceImpl mailService = new SendMailServiceImpl();
    private static MailDao             mailDao     = (MailDao) MailApplicationContext.getMailContext().getBean(
                                                                                                               "mailDao");

    public static void main(String[] args) throws IOException, MessagingException, EmailException {

        int notifyDays = 3;
        if (args.length > 0 && NumberUtils.isDigits(args[0])) {
            notifyDays = Integer.valueOf(args[0]);
        }
        Date startTime = new Date();
        logger.info("====1.Start doNotification(true, notifyDays)");
        doNotification(true, notifyDays);
        Date middle = new Date();
        logger.info("====1.end doNotification(true, notifyDays)");
        logger.info("====1.used " + (middle.getTime() - startTime.getTime()) + "ms");
        logger.info("====2.Start doNotification(false, notifyDays);");
        doNotification(false, notifyDays);
        Date endTime = new Date();
        logger.info("====2.end doNotification(false, notifyDays);");
        logger.info("====2.used " + (endTime.getTime() - middle.getTime()) + "ms");
        logger.info("====Total Time: " + (endTime.getTime() - startTime.getTime()) + "ms");

    }

    private static void doNotification(boolean isExpire, int notifyDays) {
        int page = 0;

        List<LendingWithExpireDays> lendingList = mailDao.listLendingWithExpireDays(isExpire, page * PAGE_SIZE,
                                                                                    PAGE_SIZE);
        while (lendingList != null && lendingList.size() > 0) {
            for (LendingWithExpireDays lending : lendingList) {
                if (!isExpire && (lending.getExpireDays() > notifyDays)) {
                    continue;
                }
                BookInfo bookInfo = mailDao.getBookInfoById(lending.getBookInfoId());
                if (bookInfo == null) {
                    continue;
                }
                String ownerLoginId = lending.getOwner();
                String subscriberLoginId = lending.getSubscriber();
                if (StringUtils.isBlank(ownerLoginId) || StringUtils.isBlank(subscriberLoginId)) {
                    continue;
                }

                Member owner = mailDao.getMemberByLoginId(ownerLoginId);
                Member subcriber = mailDao.getMemberByLoginId(subscriberLoginId);
                EmailInfo emailInfo = new EmailInfo(ServiceType.SHOULD_RETURN_BOOK);
                emailInfo.setOwner(owner);
                emailInfo.setBorrower(subcriber);
                emailInfo.setBookInfo(bookInfo);
                emailInfo.setLending(lending);
                emailInfo.addReceiverEmail(subcriber.getEmail());
                mailService.sendMail(emailInfo);
            }
            page += 1;
            lendingList = mailDao.listLendingWithExpireDays(isExpire, page * PAGE_SIZE, PAGE_SIZE);
        }
    }
}

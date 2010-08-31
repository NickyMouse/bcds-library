package com.alibaba.intl.bcds.goldroom.mail.checker.impl;

import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.mail.checker.EmailInfoChecker;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class EmailInfoCheckerImpl implements EmailInfoChecker {

    private static Logger logger = Logger.getLogger(EmailInfoChecker.class);

    @Override
    public boolean isOk(EmailInfo emailInfo) {
        if (emailInfo == null || emailInfo.getServiceType() == null) {
            return false;
        } else {
            ServiceType serviceType = emailInfo.getServiceType();
            switch (serviceType) {
                // 1.帐号申请通过. 2.不通过 . 8.忘记密码
                case ACCOUNT_APPROVED:
                case ACCOUNT_TBD:
                case FORGET_PASSWORD:
                    if (emailInfo.getOwner() != null) {
                        return true;
                    } else {
                        logger.error(emailInfo.getServiceType() + "; emailInfo.getOwner() is " + emailInfo.getOwner());
                    }
                    break;

                // 3.书籍被预约提醒 . 4.预约被拒绝（借阅失败）
                case RESERVATION:
                case REJECT_LEND_BOOK:
                    if (isBothMemberOk(emailInfo) && emailInfo.getBookInfo() != null
                        && emailInfo.getReservation() != null) {
                        return true;
                    } else {
                        logger.error(emailInfo.getServiceType() + "; owner is " + emailInfo.getOwner()
                                     + "; borrower is " + emailInfo.getBorrower() + "; reservation:"
                                     + emailInfo.getReservation() + "; bookInfo:" + emailInfo.getBookInfo());
                    }
                    break;
                // 5.借阅成功，提醒拿书. 6.成功还书，提醒书籍已经归还. 7.书籍借阅到期提醒
                case GET_BOOK:
                case CONFIRM_RETURN_BOOK:
                case SHOULD_RETURN_BOOK:
                    if (isBothMemberOk(emailInfo) && emailInfo.getBookInfo() != null && emailInfo.getLending() != null) {
                        return true;
                    } else {
                        logger.error(emailInfo.getServiceType() + "; owner is " + emailInfo.getOwner()
                                     + "; borrower is " + emailInfo.getBorrower() + "; lending:"
                                     + emailInfo.getLending() + "; bookInfo:" + emailInfo.getBookInfo());
                    }
                    break;
                default:
                    return false;
            }
            return false;
        }
    }

    /**
     * 检查 owner 与 borrower,都没有问题返回true,否则返回false
     * 
     * @param emailInfo
     * @return
     */
    private boolean isBothMemberOk(EmailInfo emailInfo) {
        if (emailInfo != null && emailInfo.getOwner() != null && emailInfo.getBorrower() != null) {
            return true;
        } else {
            return false;
        }
    }
}

package com.alibaba.intl.bcds.goldroom.mail.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.mail.checker.EmailInfoChecker;
import com.alibaba.intl.bcds.goldroom.mail.checker.impl.EmailInfoCheckerImpl;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilder;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilderFactory;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;

public class SendMailServiceImpl implements SendMailService {

    private static ExecutorService  executor = Executors.newFixedThreadPool(5);
    private static Logger           logger   = Logger.getLogger(SendMailServiceImpl.class);
    private static EmailInfoChecker checker  = new EmailInfoCheckerImpl();

    @Override
    public void sendMail(EmailInfo emailInfo) {
        EmailBuilder builder = EmailBuilderFactory.getEmailBuilder(emailInfo);
        if (checker.isOk(emailInfo)) {
            HtmlEmail email = builder.build();
            if (StringUtils.isNotEmpty(emailInfo.getSubject())) {
                email.setSubject(emailInfo.getSubject());
            } else {
                email.setSubject("黄金屋 [Gold Room] 系统邮件");
            }
            MailSender mailSend = new MailSender(email);
            executor.execute(mailSend);
        } else {
            logger.error("emailInfo is not ok, check your program");
        }
    }

    class MailSender implements Runnable {

        HtmlEmail email;

        MailSender(HtmlEmail email) {
            this.email = email;
        }

        @Override
        public void run() {
            try {
                email.send();
            } catch (EmailException e) {
                logger.error(e);
            }
        }
    }
}

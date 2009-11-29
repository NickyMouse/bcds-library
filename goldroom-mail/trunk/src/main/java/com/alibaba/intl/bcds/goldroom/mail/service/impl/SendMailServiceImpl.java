package com.alibaba.intl.bcds.goldroom.mail.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.mail.connection.MailConnection;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilder;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilderFactory;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;

public class SendMailServiceImpl implements SendMailService {
	private static ExecutorService executor = Executors.newFixedThreadPool(5);
	private static Logger logger = Logger.getLogger(SendMailServiceImpl.class);
	private static MailConnection mConnection;
	static {
		try {
			mConnection = MailConnection.getConnection();
		} catch (MessagingException e) {
			logger.error(e);
		}
	}

	@Override
	public void sendMail(BaseEmailInfo emailInfo) {
		EmailBuilder builder = EmailBuilderFactory.getEmailBuilder(emailInfo);
		MimeMessage messge = builder.build();
		MailSender mailSend = new MailSender(messge);
		executor.execute(mailSend);
	}

	class MailSender implements Runnable {
		MimeMessage messge;

		MailSender(MimeMessage message) {
			this.messge = message;
		}

		@Override
		public void run() {
			if (SendMailServiceImpl.mConnection == null || messge == null) {
				SendMailServiceImpl.logger
						.error("mConnection == null || messge == null");
				return;
			}
			try {
				SendMailServiceImpl.mConnection.send(messge);
			} catch (MessagingException e) {
				SendMailServiceImpl.logger.error(e);
			}
		}
	}
}

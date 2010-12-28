package com.alibaba.intl.bcds.goldroom.mail.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSendTool {

	private static final Logger logger = Logger

	.getLogger(VelocityTemplateMailMessage.class);
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void execute() {

		MailQueue mailQueue = MailQueue.getInstance();

		while (!mailQueue.isEmpty()) {

			MailDto mailDto = mailQueue.dequeue();

			MimeMessage msg = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(msg);

			try {

				helper.setFrom(mailDto.getFrom());
				helper.setSubject(mailDto.getSubject());
				helper.setTo(mailDto.getTo());
				helper.setText(mailDto.getText(), true); // 如果发的不是html内容去掉true参数
				mailSender.send(msg);

			} catch (MessagingException e) {
				logger.warn("邮件信息导常! 邮件标题为: " + mailDto.getSubject(), e);
			} catch (MailException me) {
				logger.warn("发送邮件失败! 邮件标题为: " + mailDto.getSubject(), me);
			}

		}

	}
}

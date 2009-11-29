package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.utils.TemplateMerger;

class TextMailBuilder implements EmailBuilder {
	private Session session;
	private BaseEmailInfo emailInfo;

	TextMailBuilder(Properties props, BaseEmailInfo emailInfo) {
		this.session = Session.getInstance(props, null);
		this.emailInfo = emailInfo;
	}

	public MimeMessage build() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.addHeaderLine("method=REQUEST");
			message.addHeaderLine("charset=UTF-8");
			message.addHeaderLine("component=VEVENT");

			message
					.setFrom(new InternetAddress(session
							.getProperty("username")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					emailInfo.getReceiverEmail()));
			message.setSubject("Outlook Meeting Request Using JavaMail");

			BodyPart contentPart = new MimeBodyPart();
			String content = TemplateMerger.getInstance().merge(emailInfo);
			contentPart.setText(content);
			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(contentPart);
			message.setContent(multipart);
			return message;
		} catch (Exception e) {

		}
		return null;
	}
}

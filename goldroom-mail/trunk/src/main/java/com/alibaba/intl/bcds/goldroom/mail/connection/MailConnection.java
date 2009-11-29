package com.alibaba.intl.bcds.goldroom.mail.connection;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailConnection {
	private static Logger logger = Logger.getLogger(MailConnection.class);
	private static Properties props;
	private Transport transport;
	private Session mailSession;

	public static void init() {
		props = new Properties();
		try {
			props.load(ClassLoader.getSystemClassLoader().getResourceAsStream(
					"mail.properties"));
		} catch (IOException e) {
			logger.error(e);
		}
	}

	private MailConnection(Transport transport, Session mailSession) {
		this.transport = transport;
		this.mailSession = mailSession;
	}

	public static MailConnection getConnection() throws MessagingException {
		if (props == null) {
			init();
		}
		Session session = Session.getInstance(props, null);
		Transport ts = session.getTransport("smtp");
		ts.connect((String) props.get("mail.smtp.host"), (String) props
				.get("username"), (String) props.get("password"));
		return new MailConnection(ts, session);
	}

	public void send(MimeMessage message) throws MessagingException {
		if (transport != null) {
			try {
				transport.sendMessage(message, message
						.getRecipients(javax.mail.Message.RecipientType.TO));
			} catch (MessagingException e) {
				transport.close();
				throw e;
			}
		} else {
			throw new MessagingException("Connection is not avaliable.");
		}
	}

	public Session getSession() {
		return mailSession;
	}

}

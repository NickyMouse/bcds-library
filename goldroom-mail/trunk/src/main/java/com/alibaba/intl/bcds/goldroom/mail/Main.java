package com.alibaba.intl.bcds.goldroom.mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.connection.MailConnection;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.AccountApprovedEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilder;
import com.alibaba.intl.bcds.goldroom.mail.mailbuilder.EmailBuilderFactory;

public class Main {
	public static MimeMessage messge;
	public static MailConnection gConnection;
	public static Date end;
	public static void main(String[] args) throws IOException,
			MessagingException {
		Properties props = new Properties();
		props.load(ClassLoader.getSystemClassLoader().getResourceAsStream(
				"mail.properties"));
		Date start = new Date();
		//MailConnection.init(props);
		gConnection = MailConnection.getConnection();
		Date middle = new Date();
		BaseEmailInfo emailInfo = new AccountApprovedEmailInfo(new Member());
		emailInfo.setReceiverEmail("gangyi.xiaogy@alibaba-inc.com");
	
		//emailInfo.setServiceType(ServiceType.NOTIFY_RETURN_BOOK);
//		EmailData data = new EmailData();
//		data.setBookName("haha");
//		data.setBookOwnerAliId("xiaogy");
//		data.setBookOwnerEmail("sdfds@gmail.com");
		EmailBuilder builder = EmailBuilderFactory.getEmailBuilder(emailInfo);

		messge = builder.build();
		end = new Date();
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("1");
					gConnection.send(messge);
					System.out.println("1 done "+((new Date()).getTime() -end.getTime()));
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		thread.start();
//		Thread thread2 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				try {
//					System.out.println("2");
//					gConnection.send(messge);
//					System.out.println("2 done"+((new Date()).getTime() -end.getTime()));
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		thread2.start();
		//gConnection.send(messge);
		Date sent = new Date();
		Date resent = new Date();
		System.out.println("done");
		System.out.println("connect:" + (middle.getTime() - start.getTime()));
		System.out.println("build msg:" + (end.getTime() - middle.getTime()));
		System.out.println("send msg:" + (sent.getTime() - end.getTime()));
		System.out.println("send msg:" + (resent.getTime() - sent.getTime()));
	}
}

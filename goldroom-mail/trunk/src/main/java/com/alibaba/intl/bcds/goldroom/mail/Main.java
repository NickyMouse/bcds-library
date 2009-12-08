package com.alibaba.intl.bcds.goldroom.mail;

import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.AccountApprovedEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.service.impl.SendMailServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException,
			MessagingException, EmailException {
		Member member = new Member();
		member.setEmail("xiaogy1012@gmail.com");
		member.setName("aaaa");
		member.setLoginId("bbb");
		BaseEmailInfo emailInfo = new AccountApprovedEmailInfo(member);

		SendMailServiceImpl service = new SendMailServiceImpl();

		service.sendMail(emailInfo);
	}
}

package com.alibaba.intl.goldroom.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.goldroom.test.SpringAbstractIntegrationTestcaseBase;

public class SendMailServiceTestcase extends
		SpringAbstractIntegrationTestcaseBase {

	@Autowired
	private SendMailService sendMailService;

	@Test
	public void testServiceInjection() {
		EmailInfo info = new EmailInfo(ServiceType.ACCOUNT_APPROVED);
		Member owner = new Member();
		owner.setLoginId("1111");
		owner.setName("王国成");
		info.setOwner(owner);
		List<String> receiverEmails = new ArrayList<String>();
		receiverEmails.add("wangguocheng0808@126.com");
		receiverEmails.add("wangguocheng0808@126.com");
		info.setReceiverEmails(receiverEmails);
		String[] a = info.getReceiverEmails().toArray(new String[2]);
		System.out.println(a[0] + "," + a[1]);
		sendMailService.sendVelocityMail(info, null, null, null, "");
	}
}

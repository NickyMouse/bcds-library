package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.enumeration.EmailType;
import com.alibaba.intl.bcds.goldroom.mail.utils.MailProperties;

public class EmailBuilderFactory {
	public static EmailBuilder getEmailBuilder(BaseEmailInfo emailInfo) {
		EmailBuilder builder = null;
		if (EmailType.TEXT.equals(emailInfo.getEmailType())) {
			builder = new TextMailBuilder(MailProperties.getMailProperties(),
					emailInfo);
		} else if (EmailType.EVENT.equals(emailInfo.getEmailType())) {
			builder = new EventMailBuilder(MailProperties.getMailProperties(),
					emailInfo);
		}
		return builder;
	}
}

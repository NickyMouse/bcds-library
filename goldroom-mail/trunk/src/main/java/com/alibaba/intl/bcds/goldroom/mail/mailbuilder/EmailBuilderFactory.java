package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;

public class EmailBuilderFactory {
	public static EmailBuilder getEmailBuilder(EmailInfo emailInfo) {
		return new HtmlMailBuilder(emailInfo);
	}
}

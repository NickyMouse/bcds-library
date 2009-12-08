package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;

public class EmailBuilderFactory {
	public static EmailBuilder getEmailBuilder(BaseEmailInfo emailInfo) {
		return new HtmlMailBuilder(emailInfo);
	}
}

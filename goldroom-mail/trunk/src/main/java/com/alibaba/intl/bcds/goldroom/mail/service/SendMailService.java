package com.alibaba.intl.bcds.goldroom.mail.service;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;

public interface SendMailService {
	void sendMail(BaseEmailInfo emailInfo);
}

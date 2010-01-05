package com.alibaba.intl.bcds.goldroom.mail.service;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;

public interface SendMailService {
	void sendMail(EmailInfo emailInfo);
}

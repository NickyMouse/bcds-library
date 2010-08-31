package com.alibaba.intl.bcds.goldroom.mail.service;

import java.util.Map;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;

public interface SendMailService {
	
	/**
	 * 发送邮件方法
	 * 
	 * @param info
	 * @param velocityTemplateLocation
	 *            模板文件的相对位置，你当前文件所在位置为基准，对应vm文件必须是UTF-8编码
	 * @param templateDataModule
	 *            VM文件中引用的一些template变量
	 * @param from
	 *            重构的发件人信息，系统原本有默认数据，此处可以重构
	 * @param subject
	 *            重构的邮件标题
	 */
	public void sendVelocityMail(EmailInfo info,
			String velocityTemplateLocation, Map templateDataModule,
			String from, String subject);
}

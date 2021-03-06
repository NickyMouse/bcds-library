package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.service.LendService;

/**
 * 催还书邮件工具类
 * 
 * @author wangguocheng
 * 
 */
public class MailLeandingTool {
	private static Logger logger = Logger.getLogger(MailLeandingTool.class);
	LendService lendService;

	private SendMailService sendMailService;

	public SendMailService getSendMailService() {
		return sendMailService;
	}

	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}

	public LendService getLendService() {
		return lendService;
	}

	public void setLendService(LendService lendService) {
		this.lendService = lendService;
	}

	protected static Log log = LogFactory.getLog(MailLeandingTool.class);

	public void execute() {

		// 获取过期的数据
		 logger.info("催还邮件定时器开始执行");
		List<EmailInfo> eamilInfos = lendService.listLendingEmailInfo(true);

		for (EmailInfo info : eamilInfos) {
			sendMailService.sendVelocityMail(info, null, null, null, "");
		}

		List<EmailInfo> FeamilInfos = lendService.listLendingEmailInfo(false);

		for (EmailInfo info : FeamilInfos) {
			sendMailService.sendVelocityMail(info, null, null, null, "");
		}
		logger.info("催还邮件定时器执行结束");
	}
}

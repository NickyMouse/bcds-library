package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
import com.alibaba.intl.bcds.goldroom.service.LendService;

/**
 * 催还书邮件工具类
 * 
 * @author wangguocheng
 * 
 */
public class MailLeandingTool {

	LendService lendService;

	public LendService getLendService() {
		return lendService;
	}

	public void setLendService(LendService lendService) {
		this.lendService = lendService;
	}

	protected static Log log = LogFactory.getLog(MailLeandingTool.class);

	public void execute() {

		// 获取过期的数据

		List<Lending> tExpireDays = lendService.listLendingWithExpireDays(true);

		List<Lending> fExpireDays = lendService
				.listLendingWithExpireDays(false);
		
		System.out.println("哈哈哈" + fExpireDays.size());
		System.out.println("哈哈哈" + tExpireDays.size());
		
		

		// 获取将要到期的数据

	}
}

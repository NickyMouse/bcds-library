package com.alibaba.intl.bcds.goldroom.util;

import java.text.ParseException;

import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * 用于配置轮循程序的工具类<BR>
 * 为了防止漏配置一些选项,使用构造函数方式进行注入,三个参数分别是:
 * <li>targetObject 	目标类,注入一个bean
 * <li>targetMethod		目标方法,注入一个String
 * <li>cronExpression	时间配置,格式为:0 0 * * * ?  <b>解释:从左到右分别是：秒(0-59) 分(0-59) 时(0-23) 日期(1-31) 月份(1-12) 星期(1-7)</b>
 *
 * @author chaosen.lincs@alibaba-inc.com
 * @Time 2010-11-26
 */
public class QuartzUtil extends CronTriggerBean{
	
	private static final long serialVersionUID = 1992031714439876317L;

	public QuartzUtil(Object targetObject, String targetMethod, String cronExpression) throws ClassNotFoundException, NoSuchMethodException, ParseException{
		this.setCronExpression(cronExpression);
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		bean.setTargetObject(targetObject);
		bean.setTargetMethod(targetMethod);
		bean.setName("JobDetail_" + targetObject + "_" + targetMethod);
		bean.afterPropertiesSet();
		super.setJobDetail((JobDetail)bean.getObject());
		System.out.println("prepare to start job : [" + super.getJobDetail().getName() + "], Object : ["+targetObject+"], Method : ["+targetMethod+"], cronExpression : ["+cronExpression+"]");
		
	}
}

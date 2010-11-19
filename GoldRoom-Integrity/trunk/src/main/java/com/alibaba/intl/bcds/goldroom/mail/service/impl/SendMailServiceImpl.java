package com.alibaba.intl.bcds.goldroom.mail.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.intl.bcds.goldroom.mail.checker.EmailInfoChecker;
import com.alibaba.intl.bcds.goldroom.mail.checker.impl.EmailInfoCheckerImpl;
import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.service.SendMailService;
import com.alibaba.intl.bcds.goldroom.mail.utils.FormatUtils;
import com.alibaba.intl.bcds.goldroom.mail.utils.TemplateSelector;
import com.alibaba.intl.bcds.goldroom.mail.utils.VelocityTemplateMailMessage;

public class SendMailServiceImpl implements SendMailService {

	private static Logger logger = Logger.getLogger(SendMailServiceImpl.class);
	private static EmailInfoChecker checker = new EmailInfoCheckerImpl();
	private static FormatUtils formatUtils = new FormatUtils();

	@Autowired
	private VelocityTemplateMailMessage velocityMailMessage;

	@Override
	public void sendVelocityMail(EmailInfo info,
			String velocityTemplateLocation, Map templateDataModule,
			String from, String subject) {

		if (checker.isOk(info)) {

			velocityMailMessage
					.setTemplateLocation(velocityTemplateLocation == null ? TemplateSelector
							.getInstance().getTemplate(info.getServiceType())
							: velocityTemplateLocation);
			// 若未提供模板路径，则直接通过serviceType提取对应路径

			if (templateDataModule == null || templateDataModule.isEmpty()) {
				templateDataModule = new HashMap<String, Object>();
				templateDataModule.put("info", info);
				templateDataModule.put("formatUtils", formatUtils);
			}// 若接口调用时未注入对应的vm模板变量，则使用默认的变量对象处理
			velocityMailMessage.setModel(templateDataModule);

			velocityMailMessage.setToEmails((String[]) info.getReceiverEmails()
					.toArray(new String[info.getReceiverEmails().size()]));

			if (StringUtils.isNotBlank(from))
				velocityMailMessage.setFrom(from);
			if (StringUtils.isNotBlank(subject)) {
				velocityMailMessage.setSubject(subject);
			} else if (StringUtils.isNotBlank(info.getSubject())) {
				velocityMailMessage.setSubject(info.getSubject());
			}

			velocityMailMessage.send();
		}
	}
}

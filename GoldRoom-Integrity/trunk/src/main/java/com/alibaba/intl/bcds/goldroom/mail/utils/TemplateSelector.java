package com.alibaba.intl.bcds.goldroom.mail.utils;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.mail.enumeration.ServiceType;

public class TemplateSelector {

	private static String TEMPLATES_PATH = "";

	public static TemplateSelector getInstance() {
		return new TemplateSelector();
	}

	public String getTemplate(ServiceType serviceType) {
		if (serviceType == null
				|| StringUtils.isEmpty(serviceType.getTemplateName())) {
			return StringUtils.EMPTY;
		}
		return TEMPLATES_PATH + serviceType.getTemplateName();
	}
}

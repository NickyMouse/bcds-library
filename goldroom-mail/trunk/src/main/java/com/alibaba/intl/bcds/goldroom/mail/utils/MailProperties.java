package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MailProperties {
	private static Properties props;
	private static String MAIL_PROPERTIES_FILE = "mail.properties";
	private static Logger logger = Logger.getLogger(MailProperties.class);

	public static Properties getMailProperties() {
		if (props == null) {
			props = new Properties();
			try {
				props.load(ClassLoader.getSystemClassLoader()
						.getResourceAsStream(MAIL_PROPERTIES_FILE));
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return props;
	}
}

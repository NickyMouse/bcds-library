package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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
				String basePath = Thread.currentThread()
						.getContextClassLoader().getResource("").getPath();
				FileInputStream fis = new FileInputStream(new File(basePath
						+ MAIL_PROPERTIES_FILE));
				props.load(new BufferedInputStream(fis));
			} catch (IOException e) {
				logger.error(Thread.currentThread().getContextClassLoader()
						.getResource("").getPath());
			}
		}
		return props;
	}
}

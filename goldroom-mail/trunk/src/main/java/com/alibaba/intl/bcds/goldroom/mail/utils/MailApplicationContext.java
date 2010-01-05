package com.alibaba.intl.bcds.goldroom.mail.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailApplicationContext {

    private static ClassPathXmlApplicationContext mailContext = new ClassPathXmlApplicationContext("spring/mail.xml");

    public static ApplicationContext getMailContext() {
        return mailContext;
    }

}

package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.EmailInfo;

public class TemplateMerger {

    private static TemplateMerger merger;
    private static Logger         logger      = Logger.getLogger(TemplateMerger.class);
    private static VelocityEngine velocity    = new VelocityEngine();
    private static Properties     props       = new Properties();
    private static FormatUtils    formatUtils = new FormatUtils();

    public static TemplateMerger getInstance() {
        if (merger == null) {
            merger = new TemplateMerger();
            try {
                String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
                FileInputStream fis = new FileInputStream(new File(basePath + "velocity.properties"));
                props.load(new BufferedInputStream(fis));
                velocity.init(props);
            } catch (Exception e) {
                logger.error(e);
            }
        }
        return merger;
    }

    public String merge(EmailInfo emailInfo) throws Exception {
        if (velocity == null) {
            logger.error(new NullPointerException("Velocity Engine is null"));
            return StringUtils.EMPTY;
        }

        String templateFile = TemplateSelector.getInstance().getTemplate(emailInfo.getServiceType());
        Template template;
        try {
            template = velocity.getTemplate(templateFile);
            StringWriter stringWriter = new StringWriter();
            VelocityContext context = new VelocityContext();
            context.put("info", emailInfo);
            context.put("formatUtils", formatUtils);
            template.merge(context, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }
}

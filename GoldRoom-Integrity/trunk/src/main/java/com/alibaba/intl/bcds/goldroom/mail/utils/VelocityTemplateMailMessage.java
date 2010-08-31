/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.mail.utils;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Velocity HTML Email 信息文件生成器
 * 
 * 使用时，先通过
 * 
 * @author Harrison
 *
 */
public class VelocityTemplateMailMessage {
	private static final Logger logger = Logger.getLogger(VelocityTemplateMailMessage.class);
	
	private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    private String from;
    private String subject;
    private String encoding;
    private String templateLocation;
    private String[] toEmails;
    private Map model;
    
    
    public boolean send() {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        
        try {
            if(StringUtils.isNotBlank(from))helper.setFrom(from);
            if(StringUtils.isNotBlank(subject))helper.setSubject(subject);
            helper.setTo(toEmails);
            helper.setText(getMessage(), true);   //如果发的不是html内容去掉true参数
            mailSender.send(msg);
            
        } catch (MessagingException e) {
            logger.warn("邮件信息导常! 邮件标题为: "+subject, e);
            return false;
        } catch (MailException me) {
            logger.warn("发送邮件失败! 邮件标题为: "+subject, me);
            return false;
        }
        return true;    
    }
    
    
    /**
     * 邮件模板中得到信息
     * @return 返回特发送的内容
     */
    private String getMessage() {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, 
                templateLocation, encoding, model);
    }
    
    
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getTemplateLocation() {
		return templateLocation;
	}
	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}
	public String[] getToEmails() {
		return toEmails;
	}
	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}
	public Map getModel() {
		return model;
	}
	public void setModel(Map model) {
		this.model = model;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

}

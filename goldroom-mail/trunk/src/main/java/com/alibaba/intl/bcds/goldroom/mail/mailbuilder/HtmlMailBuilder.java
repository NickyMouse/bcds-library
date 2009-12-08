package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;
import com.alibaba.intl.bcds.goldroom.mail.utils.MailProperties;
import com.alibaba.intl.bcds.goldroom.mail.utils.TemplateMerger;

class HtmlMailBuilder implements EmailBuilder {
	private static Session session;
	private BaseEmailInfo emailInfo;
	private static Logger logger = Logger.getLogger(HtmlMailBuilder.class);
	private static Properties props;
	private static Authenticator authenticator;
	private String subject = "hello";

	HtmlMailBuilder(BaseEmailInfo emailInfo) {
		if (props == null) {
			props = MailProperties.getMailProperties();
			String fromEmail = String.valueOf(props.get("from.email"));
			String pwd = (String) props.get("password");
			authenticator = new DefaultAuthenticator(fromEmail, pwd);
			session = Session.getInstance(props, authenticator);
		}

		this.emailInfo = emailInfo;
	}

	public HtmlEmail build() {
		try {
			HtmlEmail htmlEmail = new HtmlEmail();
			setCommonProp(htmlEmail);
			htmlEmail.setMailSession(session);
			String content = TemplateMerger.getInstance().merge(emailInfo);
			System.out.println(content);
			htmlEmail.setHtmlMsg(content);
			List<String> receiverEmails = emailInfo.getReceiverEmails();
			for (String receiver : receiverEmails) {
				if (StringUtils.isNotEmpty(receiver)) {
					htmlEmail.addTo(receiver);
				}
			}
			htmlEmail.setSubject(subject);

			return htmlEmail;
		} catch (Exception e) {
			logger.error(e);
		}
		logger.error("NuLL");
		return null;
	}

	private void setCommonProp(HtmlEmail email) {
		try {
			email.setHostName(String.valueOf(props.get("mail.smtp.host")));
			email.setSmtpPort(Integer.valueOf(String.valueOf(props
					.get("mail.smtp.port"))));
			String username = (String) props.get("username");
			String fromEmail = String.valueOf(props.get("from.email"));
			String pwd = (String) props.get("password");
			email.setAuthenticator(new DefaultAuthenticator(fromEmail, pwd));
			email.setFrom(fromEmail, username);
			email.setCharset("utf-8");
		} catch (EmailException e) {
			logger.error(e);
		}
	}
}

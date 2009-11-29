package com.alibaba.intl.bcds.goldroom.mail.mailbuilder;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import com.alibaba.intl.bcds.goldroom.mail.dataobject.BaseEmailInfo;

class EventMailBuilder implements EmailBuilder {
	private Properties props;
	private BaseEmailInfo email;

	EventMailBuilder(Properties props, BaseEmailInfo email) {
		this.props = props;
		this.email = email;
	}

	@Override
	public MimeMessage build() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();

		StringBuffer buffer = sb
				.append("BEGIN:VCALENDAR\n"
						+ "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
						+ "VERSION:2.0\n"
						+ "METHOD:REQUEST\n"
						+ "BEGIN:VEVENT\n"
						+ "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:xx@xx.com\n"
						+ "ORGANIZER:MAILTO:xx@xx.com\n"
						+ "DTSTART:20051208T053000Z\n"
						+ "DTEND:20051208T060000Z\n"
						+ "LOCATION:Conference room\n"
						+ "TRANSP:OPAQUE\n"
						+ "SEQUENCE:0\n"
						+ "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n"
						+ " 000004377FE5C37984842BF9440448399EB02\n"
						+ "DTSTAMP:20051206T120102Z\n"
						+ "CATEGORIES:Meeting\n"
						+ "DESCRIPTION:This the description of the meeting.\n\n"
						+ "SUMMARY:Test meeting request\n" + "PRIORITY:5\n"
						+ "CLASS:PUBLIC\n" + "BEGIN:VALARM\n"
						+ "TRIGGER:PT1440M\n" + "ACTION:DISPLAY\n"
						+ "DESCRIPTION:Reminder\n" + "END:VALARM\n"
						+ "END:VEVENT\n" + "END:VCALENDAR");
		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Fill the message
		try {
			messageBodyPart.setHeader("Content-Class",
					"urn:content-classes:calendarmessage");
			messageBodyPart.setHeader("Content-ID", "calendar_message");
			messageBodyPart.setDataHandler(new DataHandler(
					new ByteArrayDataSource(sb.toString(), "text/calendar")));// very
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

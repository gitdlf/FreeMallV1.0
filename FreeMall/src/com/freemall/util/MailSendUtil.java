package com.freemall.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.freemall.dao.entry.MailInfo;


/**
 * 邮件发送工具类
 * @author LFSenior
 *
 *下午3:20:44
 *
 */
public class MailSendUtil {
	private final static String host="smtp.163.com";
	private final static String formName="FreeMallPC@163.com";
	private final static String password="shihun19961015";
	private final static String replayAddress="FreeMallPC@163.com";
	
	/**
	 * 发送邮件方法
	 * @param info
	 * @throws Exception
	 */
	public static void sendHtmlMail(MailInfo info) throws Exception{
		info.setHost(host);
		info.setFormName(formName);
		info.setFormPassword(password);
		info.setReplayAddress(replayAddress);
		
		Message message=getMessage(info);
		//设置html内容
		message.setContent(info.getContent(),"text/html;charset=utf-8");
		//发送
		Transport.send(message);
	}
	
	/**
	 * 获取邮箱Message对象
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public static Message getMessage(MailInfo info) throws Exception{
		final Properties prop=System.getProperties();
		//配置邮箱协议
		prop.setProperty("mail.smtp.host", info.getHost());
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.user", info.getFormName());
		prop.setProperty("mail.smtp.pass", info.getFormPassword());
		
		//根据邮箱会话属性和密码验证器构造一个发送邮件的session
		Session session=Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(prop.getProperty("mail.smtp.user"),prop.getProperty("mail.smtp.pass"));
            }
		});
		
		Message message=new MimeMessage(session);
		//消息发送主题
		message.setSubject(info.getSubject());
		//接收消息的人
		message.setRecipient(RecipientType.TO, new InternetAddress(info.getToAddress()));
		//消息的发送者
		message.setFrom(new InternetAddress(prop.getProperty("mail.smtp.user"),"FreeMall"));
		message.setSentDate(new Date());
		return message;
	}
}

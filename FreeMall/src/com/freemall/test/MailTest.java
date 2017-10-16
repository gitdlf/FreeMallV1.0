package com.freemall.test;

import org.junit.Test;

import com.freemall.dao.entry.MailInfo;
import com.freemall.dao.entry.UserEntry;
import com.freemall.util.MailContentUtil;
import com.freemall.util.MailSendUtil;


public class MailTest {
	@Test
	public void registerTest(){
		String mail = "15700763932@163.com"; // 发送对象的邮箱
		String title = "感谢您注册FreeMall";
		UserEntry userEntry=new UserEntry();
		userEntry.setUserName("丁凌风");
		String content=MailContentUtil.registerContet(userEntry);
		MailInfo info = new MailInfo();
		info.setToAddress(mail);
		info.setSubject(title);
		info.setContent(content);
		try {
			MailSendUtil.sendHtmlMail(info);
		} catch (Exception e) {
			System.out.print("'" + title + "'的邮件发送失败！");
			e.printStackTrace();
		}
	}
}

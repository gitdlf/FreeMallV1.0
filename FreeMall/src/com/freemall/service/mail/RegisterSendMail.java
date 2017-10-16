package com.freemall.service.mail;

import com.freemall.dao.entry.MailInfo;
import com.freemall.dao.entry.UserEntry;
import com.freemall.util.MailContentUtil;
import com.freemall.util.MailSendUtil;
/**
 * 注册发送邮件实现类
 * @author LFSenior
 *
 *下午5:00:41
 *
 */
public class RegisterSendMail implements IRegisterSendMail {

	public void registerSendMail(UserEntry userEntry) {
		String mail = userEntry.getUserEmail(); // 发送对象的邮箱
		String title = "感谢您注册FreeMall";
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

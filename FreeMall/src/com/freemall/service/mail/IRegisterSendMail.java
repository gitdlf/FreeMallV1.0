package com.freemall.service.mail;

import com.freemall.dao.entry.UserEntry;
/**
 * 注册成功发送邮件
 * @author LFSenior
 *
 *下午4:59:20
 *
 */
public interface IRegisterSendMail {
	public void registerSendMail(UserEntry userEntry);
}

package com.freemall.dao.entry;

/**
 * 
 * @author LFSenior
 * 
 *         下午3:20:16
 * 
 */
public class MailInfo {
	// 邮箱服务器 如smtp.163.com
	private String host;
	// 用户邮箱如**@163
	private String formName;
	// 用户授权码
	private String formPassword;
	// 发送地址
	private String toAddress;
	// 发送主题
	private String subject;
	// 发送内容
	private String content;
	//接收消息邮箱
	private String replayAddress;

	public String getReplayAddress() {
		return replayAddress;
	}

	public void setReplayAddress(String replayAddress) {
		this.replayAddress = replayAddress;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormPassword() {
		return formPassword;
	}

	public void setFormPassword(String formPassword) {
		this.formPassword = formPassword;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

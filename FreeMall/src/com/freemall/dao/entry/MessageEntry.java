package com.freemall.dao.entry;

import java.sql.Date;

public class MessageEntry {
	private int messageId;
	private String content;
	private int userId;
	private int goodsId;
	private int userState;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	

	
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getCreateAuthor() {
		return createAuthor;
	}
	public void setCreateAuthor(String createAuthor) {
		this.createAuthor = createAuthor;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getModifyAuthor() {
		return modifyAuthor;
	}
	public void setModifyAuthor(String modifyAuthor) {
		this.modifyAuthor = modifyAuthor;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public MessageEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MessageEntry [messageId=" + messageId + ", content=" + content
				+ ", userId=" + userId + ", goodsId=" + goodsId
				+ ", userState=" + userState + ", createAuthor=" + createAuthor
				+ ", createDate=" + createDate + ", modifyAuthor="
				+ modifyAuthor + ", modifyDate=" + modifyDate + "]";
	}

	
	
	
}

package com.freemall.dao.entry;

import java.sql.Date;


/**
 * 用户实体类
 * @author LFSenior
 *
 *下午10:41:48
 *
 */
public class UserEntry {
	private int userId;
	private String userName;
	private String userPwd;
	private String userSex;
	private Date userBirth;
	private String userPhone;
	private String userIdCare;
	private String userEmail;
	private String userAddress;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserIdCare() {
		return userIdCare;
	}
	public void setUserIdCare(String userIdCare) {
		this.userIdCare = userIdCare;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
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
	@Override
	public String toString() {
		return "UserEntry [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userBirth=" + userBirth + ", userPhone=" + userPhone
				+ ", userIdCare=" + userIdCare + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", createAuthor="
				+ createAuthor + ", createDate=" + createDate
				+ ", modifyAuthor=" + modifyAuthor + ", modifyDate="
				+ modifyDate + "]";
	}
	public UserEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

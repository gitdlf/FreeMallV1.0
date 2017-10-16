package com.freemall.dao.entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品实体类
 * @author LFSenior
 *
 *下午10:45:59
 *
 */
public class GoodsEntry {
	private int goodsId;
	private double price;
	private String introduce;
	private String goodsName;
	private String imageAddress;
	private int childCateId;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	private int stack;
	private int parentcateid;
	//销量
	private int saleNum ;
	//商品的用户评价	
	private List<MessageEntry> messageList=new ArrayList<MessageEntry>();
	
	public List<MessageEntry> getMessageList() {
		return messageList;
	}
	
	
	public int getSaleNum() {
		return saleNum;
	}



	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}



	public void setMessageList(List<MessageEntry> messageList) {
		this.messageList = messageList;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
	public int getParentcateid() {
		return parentcateid;
	}
	public void setParentcateid(int parentcateid) {
		this.parentcateid = parentcateid;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	public int getChildCateId() {
		return childCateId;
	}
	public void setChildCateId(int childCateId) {
		this.childCateId = childCateId;
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
	public GoodsEntry() {
		super();
		// TODO Auto-generated constructor stub
	
}
	@Override
	public String toString() {
		return "GoodsEntry [goodsId=" + goodsId + ", price=" + price
				+ ", introduce=" + introduce + ", goodsName=" + goodsName
				+ ", imageAddress=" + imageAddress + ", childCateId="
				+ childCateId + ", createAuthor=" + createAuthor
				+ ", createDate=" + createDate + ", modifyAuthor="
				+ modifyAuthor + ", modifyDate=" + modifyDate + ", stack="
				+ stack + ", parentcateid=" + parentcateid + ", messageList="
				+ messageList + "]";
	}
}

package com.freemall.dao.entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 订单实体类
 * @author LFSenior
 *
 *下午10:43:27
 *
 */
public class OrderEntry {
	private int orderId; //订单id唯一标识
	private String orderNo; //订单编号
	private int statusName; //订单状态
	private int userId; //用户id
	private String address;//订单地址
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	//每个订单可能对应多个购物车项
	private List<CartEntry> cartEntryList=new ArrayList<CartEntry>();
	//订单编号的字符串数组，用于添加订单的时候
	private String[] cartIdList;
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getCartIdList() {
		return cartIdList;
	}
	public void setCartIdList(String[] cartIdList) {
		this.cartIdList = cartIdList;
	}
	public List<CartEntry> getCartEntryList() {
		return cartEntryList;
	}
	public void setCartEntryList(List<CartEntry> cartEntryList) {
		this.cartEntryList = cartEntryList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getStatusName() {
		return statusName;
	}
	public void setStatusName(int statusName) {
		this.statusName = statusName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	
	public OrderEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderEntry [orderId=" + orderId + ", orderNo=" + orderNo
				+ ", statusName=" + statusName + ", userId=" + userId
				+ ", address=" + address + ", createAuthor=" + createAuthor
				+ ", createDate=" + createDate + ", modifyAuthor="
				+ modifyAuthor + ", modifyDate=" + modifyDate
				+ ", cartEntryList=" + cartEntryList + ", cartIdList="
				+ Arrays.toString(cartIdList) + "]";
	}
	
	
}

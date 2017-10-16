package com.freemall.dao.entry;

import java.sql.Date;

public class CartEntry {
	private int cartId;
	private String proName;
	private double proPrice;
	private int proCount;
	private int userId;
	private String orderNo;
	// 商品id
	private int proId;
	private String imgAddress;
	private String createAuthor;
	private Date createDate;

	// 封装一个商品对象，便于使用商品的属性数据
	private GoodsEntry goodsEntry;

	public GoodsEntry getGoodsEntry() {
		return goodsEntry;
	}

	public void setGoodsEntry(GoodsEntry goodsEntry) {
		this.goodsEntry = goodsEntry;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProCount() {
		return proCount;
	}

	public void setProCount(int proCount) {
		this.proCount = proCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getImgAddress() {
		return imgAddress;
	}

	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public double getProPrice() {
		return proPrice;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	public CartEntry(String imgAddress, String proName, double proPrice) {
		super();
		this.imgAddress = imgAddress;
		this.proName = proName;
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "CartEntry [cartId=" + cartId + ", proName=" + proName
				+ ", proPrice=" + proPrice + ", proCount=" + proCount
				+ ", userId=" + userId + ", orderNo=" + orderNo + ", proId="
				+ proId + ", imgAddress=" + imgAddress + "]";
	}

	public CartEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

}

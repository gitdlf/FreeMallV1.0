package com.freemall.dao.entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class IndexContentEntry {
	private String title;
	private List<String> tags=new ArrayList<String>();
	private List<GoodsEntry> goodsList=new ArrayList<GoodsEntry>();
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<GoodsEntry> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsEntry> goodsList) {
		this.goodsList = goodsList;
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
	public IndexContentEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	//凌风测试数据待删除
	public IndexContentEntry(String title,List<String> tags){
		this.title=title;
		this.tags=tags;
	}
	@Override
	public String toString() {
		return "IndexContentEntry [title=" + title + ", tags=" + tags
				+ ", goodsList=" + goodsList + ", createAuthor=" + createAuthor
				+ ", createDate=" + createDate + ", modifyAuthor="
				+ modifyAuthor + ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}

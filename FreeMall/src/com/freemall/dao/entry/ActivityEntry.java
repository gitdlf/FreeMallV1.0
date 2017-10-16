package com.freemall.dao.entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ActivityEntry {
	private int activityId;
	private String activityContent;
	private Date activityDate;
	private String activityTitle;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	private String backgroundImagesAddress;
	
	private String activityNo;
	private List<ActivityNoEntry> proIdList;
	private List<ActivityNoEntry> goodsIdList;
	private List<GoodsEntry> proList=new ArrayList<GoodsEntry>();
	
	
	
	public String getBackgroundImagesAddress() {
		return backgroundImagesAddress;
	}
	public void setBackgroundImagesAddress(String backgroundImagesAddress) {
		this.backgroundImagesAddress = backgroundImagesAddress;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getActivityContent() {
		return activityContent;
	}
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	public Date getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityTitle() {
		return activityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
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
	public String getActivityNo() {
		return activityNo;
	}
	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}
	public List<ActivityNoEntry> getProIdList() {
		return proIdList;
	}
	public void setProIdList(List<ActivityNoEntry> proIdList) {
		this.proIdList = proIdList;
	}
	public List<ActivityNoEntry> getGoodsIdList() {
		return goodsIdList;
	}
	public void setGoodsIdList(List<ActivityNoEntry> goodsIdList) {
		this.goodsIdList = goodsIdList;
	}
	public List<GoodsEntry> getProList() {
		return proList;
	}
	public void setProList(List<GoodsEntry> proList) {
		this.proList = proList;
	}
	

	@Override
	public String toString() {
		return "ActivityEntry [activityId=" + activityId + ", activityContent=" + activityContent + ", activityDate="
				+ activityDate + ", activityTitle=" + activityTitle + ", createAuthor=" + createAuthor + ", createDate="
				+ createDate + ", modifyAuthor=" + modifyAuthor + ", modifyDate=" + modifyDate
				+ ", backgroundImagesAddress=" + backgroundImagesAddress + ", activityNo=" + activityNo + ", proIdList="
				+ proIdList + ", goodsIdList=" + goodsIdList + ", proList=" + proList + "]";
	}
	public ActivityEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityEntry(int activityId, String activityContent, Date activityDate, String activityTitle,
			String createAuthor, Date createDate, String modifyAuthor, Date modifyDate, String activityNo,
			List<ActivityNoEntry> proIdList, List<ActivityNoEntry> goodsIdList, List<GoodsEntry> proList) {
		super();
		this.activityId = activityId;
		this.activityContent = activityContent;
		this.activityDate = activityDate;
		this.activityTitle = activityTitle;
		this.createAuthor = createAuthor;
		this.createDate = createDate;
		this.modifyAuthor = modifyAuthor;
		this.modifyDate = modifyDate;
		this.activityNo = activityNo;
		this.proIdList = proIdList;
		this.goodsIdList = goodsIdList;
		this.proList = proList;
	}
	public ActivityEntry(int activityId, String activityNo, List<ActivityNoEntry> proIdList,
			List<ActivityNoEntry> goodsIdList, List<GoodsEntry> proList) {
		super();
		this.activityId = activityId;
		this.activityNo = activityNo;
		this.proIdList = proIdList;
		this.goodsIdList = goodsIdList;
		this.proList = proList;
	}
	
}

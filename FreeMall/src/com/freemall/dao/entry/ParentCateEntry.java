package com.freemall.dao.entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 父类别实体类
 * 
 * @author LFSenior
 * 
 *         下午10:48:16
 * 
 */
public class ParentCateEntry {
	private int parentCateId;
	private String parentCateName;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	// 体现一对多的思想
	private List<ChildCateEntry> childCateList=new ArrayList<ChildCateEntry>();
	//添加主页分类导航的两个特征商品
	private List<GoodsEntry> goodsList=new ArrayList<GoodsEntry>();
	//主页两个特征商品保存的表的主键id
	private int indexProId;

	
	public List<GoodsEntry> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsEntry> goodsList) {
		this.goodsList = goodsList;
	}

	public int getIndexProId() {
		return indexProId;
	}

	public void setIndexProId(int indexProId) {
		this.indexProId = indexProId;
	}

	public List<ChildCateEntry> getChildCateList() {
		return childCateList;
	}

	public void setChildCateList(List<ChildCateEntry> childCateList) {
		this.childCateList = childCateList;
	}

	public int getParentCateId() {
		return parentCateId;
	}

	public void setParentCateId(int parentCateId) {
		this.parentCateId = parentCateId;
	}

	public String getParentCateName() {
		return parentCateName;
	}

	public void setParentCateName(String parentCateName) {
		this.parentCateName = parentCateName;
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
		return "ParentCateEntry [parentCateId=" + parentCateId
				+ ", parentCateName=" + parentCateName + ", createAuthor="
				+ createAuthor + ", createDate=" + createDate
				+ ", modifyAuthor=" + modifyAuthor + ", modifyDate="
				+ modifyDate + ", childCateList=" + childCateList
				+ ", goodsList=" + goodsList + ", indexProId=" + indexProId
				+ "]";
	}

	public ParentCateEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParentCateEntry(int parentCateId, String parentCateName,
			String createAuthor, Date createDate, String modifyAuthor,
			Date modifyDate, List<ChildCateEntry> childCateList) {
		super();
		this.parentCateId = parentCateId;
		this.parentCateName = parentCateName;
		this.createAuthor = createAuthor;
		this.createDate = createDate;
		this.modifyAuthor = modifyAuthor;
		this.modifyDate = modifyDate;
		this.childCateList = childCateList;
	}

}

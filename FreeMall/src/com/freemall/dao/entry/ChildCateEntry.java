package com.freemall.dao.entry;

import java.sql.Date;

/**
 * 子类别实体
 * @author LFSenior
 *
 *下午10:54:05
 *
 */
/**
 * @author LFSenior
 *
 *上午7:51:55
 *
 */
public class ChildCateEntry {
	private int childCateId;
	private String childCateName;
	private int parentCateId;
	private String createAuthor;
	private Date createDate;
	private String modifyAuthor;
	private Date modifyDate;
	public int getChildCateId() {
		return childCateId;
	}
	public void setChildCateId(int childCateId) {
		this.childCateId = childCateId;
	}
	public String getChildCateName() {
		return childCateName;
	}
	public void setChildCateName(String childCateName) {
		this.childCateName = childCateName;
	}
	public int getParentCateId() {
		return parentCateId;
	}
	public void setParentCateId(int parentCateId) {
		this.parentCateId = parentCateId;
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
	public ChildCateEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChildCateEntry [childCateId=" + childCateId
				+ ", childCateName=" + childCateName + ", parentCateId="
				+ parentCateId + ", createAuthor=" + createAuthor
				+ ", createDate=" + createDate + ", modifyAuthor="
				+ modifyAuthor + ", modifyDate=" + modifyDate + "]";
	}

	//凌风测试用
	public ChildCateEntry(int childCateId,String childCateName){
		this.childCateId=childCateId;
		this.childCateName=childCateName;
	}
	
}

package com.freemall.dao.entry;

/**
 * 主页轮播图对应的导航栏目
 * @author LFSenior
 *
 *上午8:57:55
 *
 */
public class BannerEntry {
	private String parentCateId;
	private String imageAddress;
	public String getParentCateId() {
		return parentCateId;
	}
	public void setParentCateId(String parentCateId) {
		this.parentCateId = parentCateId;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	public BannerEntry(String parentCateId, String imageAddress) {
		super();
		this.parentCateId = parentCateId;
		this.imageAddress = imageAddress;
	}
	public BannerEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BannerEntry [parentCateId=" + parentCateId + ", imageAddress="
				+ imageAddress + "]";
	}
	
}

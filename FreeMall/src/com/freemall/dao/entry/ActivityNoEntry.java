package com.freemall.dao.entry;

public class ActivityNoEntry {
	private int  proId;
	private String backgroundImagesAddress;
	
	

	public String getBackgroundImagesAddress() {
		return backgroundImagesAddress;
	}

	public void setBackgroundImagesAddress(String backgroundImagesAddress) {
		this.backgroundImagesAddress = backgroundImagesAddress;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	@Override
	public String toString() {
		return "ActivityNoEntry [proId=" + proId + "]";
	}

	public ActivityNoEntry(int proId) {
		super();
		this.proId = proId;
	}

	public ActivityNoEntry() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

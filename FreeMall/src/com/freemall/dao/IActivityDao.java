package com.freemall.dao;


import com.freemall.dao.entry.ActivityEntry;

/**
 * 活动接口
 * @author LFSenior
 *
 *上午10:03:24
 *
 */
public interface IActivityDao {
	/**
	 * 根据活动no获取活动信息
	 * @param activityNo
	 * @return
	 */
	public ActivityEntry getActivity(String activityNo);
	
}


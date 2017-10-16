package com.freemall.service;

import com.freemall.dao.entry.ActivityEntry;

/**
 * 活动服务接口
 * @author LFSenior
 *
 *上午10:05:23
 *
 */
public interface IActivityService {
	/**
	 * 根据活动no获取活动信息
	 * @param activityNo
	 * @return
	 */
	public ActivityEntry getActivity(int activityNo);
}

package com.freemall.dao;

import com.freemall.dao.entry.UserEntry;

/**
 * 登录处理接口
 * @author LFSenior
 *
 *下午10:36:37
 *
 */
public interface ILoginDao {
	/**
	 * 登录方法
	 * @param userEntry 封装好的对象数据
	 * @return 返回是否登录成功
	 */
	public boolean login(UserEntry userEntry);
	
}

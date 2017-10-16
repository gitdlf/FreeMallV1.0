package com.freemall.service;

import com.freemall.dao.entry.UserEntry;

/**
 * 登录服务接口，实现登录功能
 * @author LFSenior
 *
 *上午10:24:39
 *
 */
public interface ILoginService {
	/**
	 * 登录方法，实现用户登录的功能
	 * @param userEntry 封装用户数据
	 * @return 返回登录是否成功
	 * 	
	 */
	public boolean login(UserEntry userEntry);
}

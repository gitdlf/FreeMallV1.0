package com.freemall.service;

import com.freemall.dao.entry.UserEntry;


/**
 * 用户注册接口
 * @author LFSenior
 *
 *下午12:33:24
 *
 */
public interface IRegisterService {
	/**
	 * 注册方法
	 * @param userEntry 封装好的用户注册信息
	 * @return 返回是否登录成功
	 */
	public boolean register(UserEntry userEntry);
}

package com.freemall.dao;

import com.freemall.dao.entry.UserEntry;

/**
 * 用户注册接口
 * 
 * @author LFSenior
 *
 *上午10:30:23
 *
 */
public interface IRegisterDao {

	/**
	 * 注册方法
	 * @param userEntry 封装用户提交的注册信息
	 * @return 返回是否注册成功
	 */
	public boolean register(UserEntry userEntry);
}

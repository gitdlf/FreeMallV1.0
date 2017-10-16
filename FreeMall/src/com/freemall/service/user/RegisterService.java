package com.freemall.service.user;

import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.RegisterDao;
import com.freemall.service.IRegisterService;

/**
 * 用户注册服务
 * @author LFSenior
 *
 *下午12:35:28
 *
 */
public class RegisterService implements IRegisterService {

	public boolean register(UserEntry userEntry) {
		//调用dao层的数据库操作		
		return new RegisterDao().register(userEntry);
	}

}

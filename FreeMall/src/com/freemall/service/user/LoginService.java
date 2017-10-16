package com.freemall.service.user;

import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.LoginDao;
import com.freemall.service.ILoginService;

/**
 * 登录服务
 * @author LFSenior
 *
 *上午10:27:21
 *
 */
public class LoginService implements ILoginService {

	public boolean login(UserEntry userEntry) {
		// TODO Auto-generated method stub
		//调用dao层login方法		
		return new LoginDao().login(userEntry);
	}

}

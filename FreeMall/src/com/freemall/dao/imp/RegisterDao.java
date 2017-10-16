package com.freemall.dao.imp;

import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.UserEntry;

/**
 * 用户注册的数据库操作
 * 
 * @author LFSenior
 * 
 *         下午8:03:23
 * 
 */
public class RegisterDao extends JdbcBase {
	/**
	 * 用户注册
	 * 
	 * @param userEntry
	 * @return
	 */
	public Boolean register(UserEntry userEntry) {
		int num = 0;// 数据返回的受影响的行数
		// 注册的sql语句99
		// 性别先暂时默认为男
		String sql = "insert into users_t(userid,username,userpwd,usersex,userbirth,userphone,useridcare,useremail,useraddress,createauthor) values (users_s.nextval,?,?,'male',?,?,?,?,?,?)";
		num = update(sql, userEntry.getUserName(), userEntry.getUserPwd(),
				userEntry.getUserBirth(), userEntry.getUserPhone(),
				userEntry.getUserIdCare(), userEntry.getUserEmail(),
				userEntry.getUserAddress(), userEntry.getUserName());
		if(num==0){
			//注册失败
			return false;
		}
		//表示注册成功
		new LoginDao().login(userEntry);
		return true;
	}
}

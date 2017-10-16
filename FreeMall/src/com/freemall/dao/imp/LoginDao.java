package com.freemall.dao.imp;

import java.util.List;


import com.freemall.dao.ILoginDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.UserEntry;
import com.freemall.util.JDBCUtil;


/**
 * 登录数据处理类
 * @author LFSenior
 *
 *上午8:37:57
 *
 */
public class LoginDao extends JdbcBase implements ILoginDao{
	/**
	 * 登录方法
	 * @param userEntry 封装好的对象数据
	 * @return 返回是否登录成功
	 */
	public boolean login(UserEntry userEntry){
		//查询sql语句		
		String sql="select userid,username,userpwd,usersex,userbirth,userphone,useridcare,useremail,useraddress from users_t where username=? and userpwd=?";
		//获取得到的结果
		List<UserEntry> query = query(sql, UserEntry.class, userEntry.getUserName(),userEntry.getUserPwd());
		if(query.size()==0){
			return false;
		}
		//查询到的数据校验		
		JDBCUtil.objectDateCopy(userEntry, query.get(0));
		return true;
	}
}

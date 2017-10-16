package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;

/**
 * 查询购物车信息的dao层
 * @author LFSenior
 *
 *下午5:30:11
 *
 */
public interface IQueryCartDao {
	/**
	 * 查询购物车方法
	 * 如果订单编号不存在器状态码为0
	 * @param loginUser 登录的用户对象信息
	 * @return 购物车项
	 */
	public List<CartEntry> queryCart(UserEntry loginUser);
}

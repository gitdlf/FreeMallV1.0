package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;

/**
 * 查询购物车服务接口
 * @author LFSenior
 *
 *下午7:36:43
 *
 */
public interface IQueryCartService {
	/**
	 * 查询购物车方法
	 * 如果订单编号不存在器状态码为0
	 * @param loginUser 登录的用户对象信息
	 * @return 购物车项
	 */
	public List<CartEntry> queryCart(UserEntry loginUser);
}

package com.freemall.dao;

import com.freemall.dao.entry.OrderEntry;

/**
 * 当发生订单提交的时候，将购物车项的订单
 * @author LFSenior
 *
 *上午10:29:57
 *
 */
public interface IUpdateCartOrderNoDao {
	/**
	 * 更新购物车项订单编号的方法
	 * @param orderEntry 封装好的订单信息
	 */
	public void updateCartOrderNo(OrderEntry orderEntry);
}

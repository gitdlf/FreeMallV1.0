package com.freemall.dao;

import com.freemall.dao.entry.OrderEntry;

/**
 * 更具订单编号查找订单
 * @author LFSenior
 *
 *下午5:01:37
 *
 */
public interface IQueryOrderByOrderNoDao {
	/**
	 * 通过订单的id查询订单
	 * @param orderEntry 订单实体信息
	 * @return
	 */
	public boolean queryOrderByOrderNo(OrderEntry orderEntry);
}

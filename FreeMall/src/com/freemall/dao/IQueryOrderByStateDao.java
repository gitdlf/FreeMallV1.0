package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;

/**
 * 更具订单状态查询特定状态的订单数据
 * @author LFSenior
 *
 *下午1:06:37
 *
 */
public interface IQueryOrderByStateDao {
	/**
	 * 更具订单状态，查询订单
	 * @param orderState 订单状态
	 * @param userId 用户id
	 * @return 返回订单的集合
	 */
	public List<OrderEntry> getOrderByState(int orderState,int userId);
}

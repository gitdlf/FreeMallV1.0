package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;

/**
 * 根据订单状态与用户id查询订单
 * @author LFSenior
 *
 *下午2:17:29
 *
 */
public interface IQueryOrderByStateService {
	/**
	 * 更具订单状态，查询订单
	 * @param orderState 订单状态
	 * @param userId 用户id
	 * @return 返回订单的集合
	 */
	public List<OrderEntry> getOrderByState(int orderState,int userId);
}

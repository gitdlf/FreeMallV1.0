package com.freemall.service;

import com.freemall.dao.entry.OrderEntry;

/**
 * 查询订单的服务接口
 * @author LFSenior
 *
 *下午5:37:45
 *
 */
public interface IQueryOrderByOrderNoService {
	/**
	 * 通过订单的id查询订单
	 * @param orderEntry 订单实体信息
	 * @return
	 */
	public boolean queryOrderByOrderNo(OrderEntry orderEntry);
}

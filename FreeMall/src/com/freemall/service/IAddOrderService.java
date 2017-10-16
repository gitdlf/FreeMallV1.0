package com.freemall.service;

import com.freemall.dao.entry.OrderEntry;

/**
 * 增加订单的接口类
 * @author LFSenior
 *
 *上午8:54:03
 *
 */
public interface IAddOrderService {
	/**
	 * 增加订单实现方法
	 * @param orderEntry 封装好的订单数据
	 * @return boolean 返回是否添加成功
	 */
	public boolean addOrder(OrderEntry orderEntry);
}

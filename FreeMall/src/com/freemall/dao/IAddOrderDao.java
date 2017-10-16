package com.freemall.dao;

import com.freemall.dao.entry.OrderEntry;

/**
 * 增加订单的dao接口
 * @author LFSenior
 *
 *上午10:28:55
 *
 */
public interface IAddOrderDao {
	/**
	 * 增加订单实现方法
	 * @param orderEntry 封装好的订单数据
	 * @return boolean 返回是否添加成功
	 */
	public boolean addOrder(OrderEntry orderEntry);
}

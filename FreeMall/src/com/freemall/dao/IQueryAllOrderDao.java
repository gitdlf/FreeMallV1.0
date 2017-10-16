package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;

/**
 * 查询所有订单的dao接口
 * @author LFSenior
 *
 *下午1:00:51
 *
 */
public interface IQueryAllOrderDao {
	/**
	 * 获取所有订单的实现方法
	 * @param userId 用户id
	 * @return 返回封装的OrderEntry对象的List集合对象
	 * 
	 */
	public List<OrderEntry> getAllOrder(int userId);
}

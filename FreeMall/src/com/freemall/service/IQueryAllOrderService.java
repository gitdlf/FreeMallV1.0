package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;

/**
 * 根据用户id查询所有订单的服务接口
 * @author LFSenior
 *
 *下午2:15:15
 *
 */
public interface IQueryAllOrderService {
	/**
	 * 获取所有订单的实现方法
	 * @param userId 用户id
	 * @return 返回封装的OrderEntry对象的List集合对象
	 * 
	 */
	public List<OrderEntry> getAllOrder(int userId);
}

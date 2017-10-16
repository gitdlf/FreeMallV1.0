package com.freemall.service.order;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.imp.QueryAllOrderDao;
import com.freemall.service.IQueryAllOrderService;

/**
 * 根据用户id查询所有订单的服务
 * @author LFSenior
 *
 *下午2:16:35
 *
 */
public class QueryAllOrderService implements IQueryAllOrderService {

	public List<OrderEntry> getAllOrder(int userId) {
		return new QueryAllOrderDao().getAllOrder(userId);
	}

}

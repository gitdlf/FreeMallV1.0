package com.freemall.service.order;

import java.util.List;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.imp.QueryOrderByStateDao;
import com.freemall.service.IQueryOrderByStateService;

/**
 * 根据用户名和订单状态查询订单信息
 * @author LFSenior
 *
 *下午2:19:02
 *
 */
public class QueryOrderByStateService implements IQueryOrderByStateService {

	public List<OrderEntry> getOrderByState(int orderState, int userId) {
		return new QueryOrderByStateDao().getOrderByState(orderState, userId);
	}

}

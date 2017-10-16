package com.freemall.service.order;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.imp.QueryOrderByOrderNoDao;
import com.freemall.service.IQueryOrderByOrderNoService;

public class QueryOrderByOrderNoService implements IQueryOrderByOrderNoService {

	public boolean queryOrderByOrderNo(OrderEntry orderEntry) {
		// TODO Auto-generated method stub
		return new QueryOrderByOrderNoDao().queryOrderByOrderNo(orderEntry);
	}

}

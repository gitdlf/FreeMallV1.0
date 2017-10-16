package com.freemall.service.order;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.imp.AddOrderDao;
import com.freemall.service.IAddOrderService;

/**
 * 增加订单的服务实现类
 * @author LFSenior
 *
 *上午8:55:02
 *
 */
public class AddOrderService implements IAddOrderService {

	public boolean addOrder(OrderEntry orderEntry) {
		return new AddOrderDao().addOrder(orderEntry);
	}

}

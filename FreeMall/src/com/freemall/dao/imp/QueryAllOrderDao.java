package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IQueryAllOrderDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.OrderEntry;

/**
 * 查询所有订单的实现类
 * @author LFSenior
 *
 *下午1:10:13
 *
 */
public class QueryAllOrderDao extends JdbcBase implements IQueryAllOrderDao {

	public List<OrderEntry> getAllOrder(int userId) {
		String sql="select orderNo,statusname,userid,createDate from order_t where userid=?  order by createdate desc";
		List<OrderEntry> orderList = query(sql, OrderEntry.class, userId);
		//说明没有订单,返回null
		if(orderList.size()==0){
			return null;
		}
		//更具素有订单id查询所有购物车记录并封装到订单对象中
		for (OrderEntry orderEntry : orderList) {
			List<CartEntry> cartList = new QueryCartByOrderNoDao().queryCartByOrderNo(orderEntry.getOrderNo());
			orderEntry.setCartEntryList(cartList);
		}
		return orderList;
	}

}

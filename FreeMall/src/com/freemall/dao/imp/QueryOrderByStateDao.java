package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IQueryOrderByStateDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.OrderEntry;

/**
 * 更具状态查询订单数据dao实现类
 * @author LFSenior
 *
 *下午1:58:49
 *
 */
public class QueryOrderByStateDao extends JdbcBase implements IQueryOrderByStateDao{

	public List<OrderEntry> getOrderByState(int orderState,int userId) {
		//查询订单的sql语句
		String sql="select orderNo,statusname,userid,createDate from order_t where userid=? and statusname=?  order by createdate desc";
		//查询订单，并将数据封装到OrderEntry中，并添加到List集合中
		List<OrderEntry> orderList = query(sql, OrderEntry.class, userId,orderState);
		//更具订单no查询cart表中的说有该订单项下的商品
		for (OrderEntry orderEntry : orderList) {
			//所有该订单下的购物车项
			List<CartEntry> cartItemList = new QueryCartByOrderNoDao().queryCartByOrderNo(orderEntry.getOrderNo());
			//将这些购物车项绑定到订单上
			orderEntry.setCartEntryList(cartItemList);
		}
		return orderList;
	}

}

package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IQueryOrderByOrderNoDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.OrderEntry;
import com.freemall.util.JDBCUtil;

/**
 * 更具订单编号查询订单详细信息
 * 
 * @author LFSenior
 * 
 *         下午5:04:38
 * 
 */
public class QueryOrderByOrderNoDao extends JdbcBase implements
		IQueryOrderByOrderNoDao {

	public boolean queryOrderByOrderNo(OrderEntry orderEntry) {
		// sql语句
		String sql = "select orderid,orderno,userid,createauthor,createdate,address,statusname  from order_t where userid=? and orderno=?";
		// 查询，获取订单的集合对象
		List<OrderEntry> orderList = query(sql, OrderEntry.class,
				orderEntry.getUserId(), orderEntry.getOrderNo());
		// 判断是否查到，如果==0说明没有数据返回false
		if (orderList.size() == 0) {
			return false;
		}
		// 复制数据
		JDBCUtil.objectDateCopy(orderEntry, orderList.get(0));
		// 封装订单商品信息
		// 根据订单id查询所有购物车记录并封装到订单对象中
		List<CartEntry> cartList = new QueryCartByOrderNoDao()
				.queryCartByOrderNo(orderEntry.getOrderNo());
		//为订单实体封装购物车项集合，也就是订单商品项目集合
		orderEntry.setCartEntryList(cartList);
		return true;
	}

}

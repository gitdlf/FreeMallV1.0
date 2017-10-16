package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IQueryCartByOrderNoDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;

/**
 * 更具订单编号查询所有购物记录
 * @author LFSenior
 *
 *下午1:35:35
 *
 */
public class QueryCartByOrderNoDao extends JdbcBase implements IQueryCartByOrderNoDao {

	public List<CartEntry> queryCartByOrderNo(String orderNo) {
		String sql="select cartid,proname,proprice,procount,userid,orderno,proid,imgAddress from cart_item_view where orderno=?";
		List<CartEntry> cartList = query(sql, CartEntry.class, orderNo);
		return cartList;
	}

}

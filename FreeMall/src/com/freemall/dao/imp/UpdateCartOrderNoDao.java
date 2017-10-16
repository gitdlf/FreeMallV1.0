package com.freemall.dao.imp;

import com.freemall.dao.IUpdateCartOrderNoDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.OrderEntry;

/**
 * 更新购物车编号的实现类
 * @author LFSenior
 *
 *上午11:37:09
 *
 */
public class UpdateCartOrderNoDao extends JdbcBase implements IUpdateCartOrderNoDao {

	public void updateCartOrderNo(OrderEntry orderEntry) {
		//更新cart表的sql语句
		String sql="update cart_t set orderno=? where cartid=? and userid=?";
		//通过for循环更新
		for(String cartId:orderEntry.getCartIdList()){
			//更新cart_t表
			update(sql, orderEntry.getOrderNo(),cartId,orderEntry.getUserId());
		}
	}

}

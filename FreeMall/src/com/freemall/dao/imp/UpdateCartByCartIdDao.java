package com.freemall.dao.imp;

import com.freemall.dao.IUpdateCartByCartIdDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;

/**
 * 更新购物车dao实现
 * @author LFSenior
 *
 *上午9:07:21
 *
 */
public class UpdateCartByCartIdDao extends JdbcBase implements IUpdateCartByCartIdDao {

	public void updateCartByCartId(CartEntry cartEntry) {
		String sql="update cart_t set procount=? where cartid=?";
		update(sql, cartEntry.getProCount(),cartEntry.getCartId());
	}

}

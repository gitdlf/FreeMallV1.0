package com.freemall.dao;

import com.freemall.dao.entry.CartEntry;


/**
 * 更具购物车的id更新购物车
 * @author LFSenior
 *
 *上午9:06:01
 *
 */
public interface IUpdateCartByCartIdDao {
	/**
	 * 根据购物车id更新购物车
	 * @param cartId
	 */
	public void updateCartByCartId(CartEntry cartEntry);
}

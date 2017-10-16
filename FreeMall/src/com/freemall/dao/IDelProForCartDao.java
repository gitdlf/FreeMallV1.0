package com.freemall.dao;

import com.freemall.dao.entry.CartEntry;

/**
 * 删除购物车中的商品dao接口
 * @author LFSenior
 *
 *上午8:57:02
 *
 */
public interface IDelProForCartDao {
	/**
	 * 删除购物车中的商品
	 * @param cartEntry 购物车项的封装
	 * @return
	 */
	public boolean delProForCart(CartEntry cartEntry);
}

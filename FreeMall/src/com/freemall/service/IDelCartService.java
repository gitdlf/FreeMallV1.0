package com.freemall.service;

import com.freemall.dao.entry.CartEntry;

/**
 * 删除购物车项的service
 * @author LFSenior
 *
 *下午8:36:40
 *
 */
public interface IDelCartService {
	/**
	 * 删除购物车中的商品
	 * @param cartEntry 购物车项的封装
	 * @return
	 */
	public boolean delProForCart(CartEntry cartEntry);
}

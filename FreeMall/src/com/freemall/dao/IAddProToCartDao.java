package com.freemall.dao;

import com.freemall.dao.entry.CartEntry;

/**
 * 增加商品到购物车
 * @author LFSenior
 *
 *上午8:49:25
 *
 */
public interface IAddProToCartDao {
	/**
	 * 增加商品到购物车
	 * @param cartEntry 封装好的购物车项
	 * @return 返回是否添加成功
	 */
	public boolean addProToCart(CartEntry cartEntry);
}

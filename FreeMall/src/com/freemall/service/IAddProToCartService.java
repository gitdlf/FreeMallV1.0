package com.freemall.service;

import com.freemall.dao.entry.CartEntry;

/**
 * 增加商品到购物车服务接口
 * @author LFSenior
 *
 *上午8:18:47
 *
 */
public interface IAddProToCartService {
	/**
	 * 增加商品到购物车
	 * @param cartEntry 封装好的购物车项
	 * @return 返回是否添加成功
	 */
	public boolean addProToCart(CartEntry cartEntry);
}

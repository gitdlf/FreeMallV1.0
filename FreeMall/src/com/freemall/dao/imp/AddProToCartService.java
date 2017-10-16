package com.freemall.dao.imp;

import com.freemall.dao.entry.CartEntry;
import com.freemall.service.IAddProToCartService;
/**
 * 增加商品到购物车的服务实现类
 * @author LFSenior
 *
 *上午8:19:27
 *
 */
public class AddProToCartService implements IAddProToCartService{

	public boolean addProToCart(CartEntry cartEntry) {
		return new AddProToCartDao().addProToCart(cartEntry);
	}

}

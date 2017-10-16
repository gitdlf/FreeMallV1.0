package com.freemall.service.cart;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.imp.DelProForCart;
import com.freemall.service.IDelCartService;

public class DelCartService implements IDelCartService {

	public boolean delProForCart(CartEntry cartEntry) {
		return new DelProForCart().delProForCart(cartEntry);
	}

}

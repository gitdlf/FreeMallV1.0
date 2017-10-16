package com.freemall.service.cart;

import java.util.List;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.QueryCartDao;
import com.freemall.service.IQueryCartService;

/**
 * 查询购物车服务实现类
 * @author LFSenior
 *
 *下午7:38:02
 *
 */
public class QueryCartService implements IQueryCartService {

	public List<CartEntry> queryCart(UserEntry loginUser) {
		return new QueryCartDao().queryCart(loginUser);
	}

}

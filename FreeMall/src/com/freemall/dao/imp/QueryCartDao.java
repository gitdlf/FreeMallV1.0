package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IQueryCartDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.UserEntry;

/**
 * 查询购物车的实现类
 * @author LFSenior
 *
 *下午5:40:58
 *
 */
public class QueryCartDao extends JdbcBase implements IQueryCartDao {

	public List<CartEntry> queryCart(UserEntry loginUser) {
		//查询的sl语句
		String sql="select cartid,proname,proprice,procount,userid,proid,createauthor,createdate  from cart_t where userid=? and orderno is null  and cartstate=1";
		//查询
		List<CartEntry> cartEntryList = query(sql, CartEntry.class,loginUser.getUserId());
		//便利所有购物车项，封装商品数据
		for (CartEntry cartEntry : cartEntryList) {
			sql="select * from goods_t where goodsId=?";
			List<GoodsEntry> goodsList = query(sql, GoodsEntry.class, cartEntry.getProId());
			if(goodsList.size()>0){
				cartEntry.setGoodsEntry(goodsList.get(0));
			}
		}
		//返回查询到的结果
		return cartEntryList;
	}

}

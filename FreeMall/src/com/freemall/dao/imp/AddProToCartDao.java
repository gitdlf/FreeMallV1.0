package com.freemall.dao.imp;

import com.freemall.dao.IAddProToCartDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;

/**
 * 增加商品到购物车
 * @author wx
 *
 *上午8:51:22
 *
 */
public class AddProToCartDao extends JdbcBase implements IAddProToCartDao {

	public boolean addProToCart(CartEntry cartEntry) {
		//插入购物车的sql语句
		String sql="insert into cart_t (cartid,proname,proprice,procount,userid,proid,createauthor ) values (cart_s.nextval,?,?,?,?,?,?)";
		//执行更新语句，获得影响的行数
		Integer line = update(sql, cartEntry.getProName(),cartEntry.getProPrice(),cartEntry.getProCount(),cartEntry.getUserId(),cartEntry.getProId(),cartEntry.getCreateAuthor());
		if(line==0){
			//判断如果影响的行数==0说明添加购物车失败
			return false;
		}
		//说明添加购物成功
		return true;
	}

}

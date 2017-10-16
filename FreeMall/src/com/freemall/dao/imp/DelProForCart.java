package com.freemall.dao.imp;

import com.freemall.dao.IDelProForCartDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.CartEntry;

/**
 * 删除购物车实现类
 * @author LFSenior
 *
 *上午9:05:40
 *
 */
public class DelProForCart extends JdbcBase implements IDelProForCartDao {

	public boolean delProForCart(CartEntry cartEntry) {
		//sql语句
		String sql="update cart_t set cartstate=0 where cartid=?";
		//调用方法
		Integer line = update(sql, cartEntry.getCartId());
		//处理返回结构
		if(line==0){
			//说明删除失败
			return false;
		}
		//删除成功
		return true;
	}

}

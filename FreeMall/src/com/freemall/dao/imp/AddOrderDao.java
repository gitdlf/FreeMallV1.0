package com.freemall.dao.imp;

import com.freemall.dao.IAddOrderDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.OrderEntry;

/**
 * 增加订单的实现类
 * @author LFSenior
 *
 *上午11:14:41
 *
 */
public class AddOrderDao extends JdbcBase implements IAddOrderDao {

	/**
	 * 增加订单的方法
	 */
	public boolean addOrder(OrderEntry orderEntry) {
		//用于标记是否添加成功
		boolean judge=false;
		//在订单表中插入订单数据sql
		String sql="insert into order_t (orderid,orderno,statusname,userid,createauthor,address) values (order_s.nextval,?,?,?,?,?)";
		//调用数据库更新方法将数据插入到订单表中
		Integer line = update(sql, orderEntry.getOrderNo(),orderEntry.getStatusName(),orderEntry.getUserId(),orderEntry.getCreateAuthor(),orderEntry.getAddress());
		if(line>0){
			//说明插入成功
			judge=true;
		}
		if(judge){
			//订单数据插入成功，修改购物车项数据
			new UpdateCartOrderNoDao().updateCartOrderNo(orderEntry);
		}
		//返回标记
		return judge;
	}

}

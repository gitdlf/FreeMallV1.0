package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IProInfomationDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.MessageEntry;

/**
 * 更具id获取商品信息dao实现类
 * @author LFSenior
 *
 *上午11:32:55
 *
 */
public class ProInfomationDao extends JdbcBase implements IProInfomationDao {

	public GoodsEntry getProInfomation(String goodsId) {
		// TODO Auto-generated method stub
		//更具商品id查询商品信息的sql语句
		String sql="select * from goods_t where goodsId=?";
		//调用jdbc的query方法，将商品数据封装到GoodsEntry中，并添加到list集合中
		List<GoodsEntry> goodsList = query(sql, GoodsEntry.class, goodsId);
		//如果goodsList.size()>0说明有数据，这将第一个数据返回
		if(goodsList.size()>0){
			//为商品绑定评价信息
			sql="select * from message_t where goodsid=?";
			//查询商品的留言信息，并将信息封装到MessageEntry中，同时添加到List集合中
			List<MessageEntry> messageList = query(sql, MessageEntry.class, goodsList.get(0).getGoodsId());
			goodsList.get(0).setMessageList(messageList);
			return goodsList.get(0);
		}
		//说明没有该商品，返回null
		return null;
	}

}

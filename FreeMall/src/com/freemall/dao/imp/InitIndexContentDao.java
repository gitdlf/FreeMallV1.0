package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IInitIndexContentDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.GoodsEntry;

/**
 * 主页获取商品信息的dao实现类
 * @author LFSenior
 *
 *下午7:04:10
 *
 */
public class InitIndexContentDao extends JdbcBase implements IInitIndexContentDao {

	public List<GoodsEntry> getContentGoods(String parentCateId) {
		//仅仅随机查询6条数据6条记录
		String sql="select goodsid,price,introduce,goodsname,imageaddress,childcateid,parentcateid,stack from (select goods_t.*,rownum rn from goods_t where rownum<=? and parentcateid=? ) where rn>? ";
		//获取开始的随机值
		int num=(int) (Math.random()*20);
		//执行查询方法将数据封装到GoodsEntry中，并添加到list集合中
		List<GoodsEntry> goodsEntryList = query(sql, GoodsEntry.class, num+6,parentCateId,num);
		//将获取到的数据返回
		return goodsEntryList;
	}

}

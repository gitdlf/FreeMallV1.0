package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IGetProByProIdDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.GoodsEntry;

/**
 * 
 * @author LFSenior
 *
 *上午8:27:59
 *
 */
public class GetProByProIdDao extends JdbcBase implements IGetProByProIdDao {

	public GoodsEntry getProByProId(String proId) {
		String sql="select *from goods_t where goodsid=?";
		List<GoodsEntry> goodsEntryList = query(sql, GoodsEntry.class, proId);
		if(goodsEntryList.size()>0){
			return goodsEntryList.get(0);
		}
		return null;
	}

}

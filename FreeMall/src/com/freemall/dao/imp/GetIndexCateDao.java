package com.freemall.dao.imp;

import java.util.List;
import com.freemall.dao.IGetIndexCateDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.ChildCateEntry;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.ParentCateEntry;

/**
 * 首页导航数据获取
 * @author LFSenior
 *
 *上午9:56:36
 *
 */
public class GetIndexCateDao extends JdbcBase implements IGetIndexCateDao {

	public List<ParentCateEntry> getIndexCateNav() {
		// TODO Auto-generated method stub
		//查询主页类别导航视图，获得首页需要的导航数据
		String sql="select parentCateId,parentCateName from indexcatenav_view";
		List<ParentCateEntry> parentCateList=query(sql, ParentCateEntry.class);
		//遍历父类获取所有子类数据
		for (ParentCateEntry parentCateEntry : parentCateList) {
			//查询子类表获取父类对应的子类别
			sql="select childcateid,childcatename from childcate_t where parentcateid=?";
			//将数据封装到ChildCateEntry中并保存在List集合中
			List<ChildCateEntry> childCateList = query(sql, ChildCateEntry.class, parentCateEntry.getParentCateId());
			//将子类数据保存到ParentCateEntry中
			parentCateEntry.setChildCateList(childCateList);
			//更具父类id获取主页特征商品
			sql="select * from indexcatepro_view where parentcateid=?";
			//将数据封装GoodsEntry中，并保存到list集合中
			List<GoodsEntry> goodsList = query(sql, GoodsEntry.class, parentCateEntry.getParentCateId());
			//将特征商品数据保存到parencateEntry中
			parentCateEntry.setGoodsList(goodsList);
		}
		//返回结果
		return parentCateList;
	}
	


}

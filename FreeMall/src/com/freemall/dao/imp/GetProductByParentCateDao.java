package com.freemall.dao.imp;

import java.util.List;

import com.freemall.dao.IGetProductByParentCateDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;

public class GetProductByParentCateDao extends JdbcBase implements
		IGetProductByParentCateDao {

	public List<GoodsEntry> getProductParent(int parentCateId, PageBean pageBean) {
		// 设置商品记录总数
		pageBean.setTotalCount(getTotalCount(parentCateId));
		/*
		 * 1. 如果当前页 <= 0; 当前页设置当前页为1; 2. 如果当前页 > 最大页数； 当前页设置为最大页数
		 */
		if (pageBean.getCurrentPage() <= 0) {
			pageBean.setCurrentPage(1);
		}
		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		// 1. 获取当前页： 计算查询的起始行、返回的行数
		int currentPage = pageBean.getCurrentPage();
		// 起始行
		int index = (currentPage - 1) * pageBean.getPageCount();
		// 返回的行数
		// 如果当前页乘以页面数>总数
		int count = currentPage * pageBean.getPageCount() > pageBean
				.getTotalCount() ? pageBean.getTotalCount() - index : pageBean
				.getPageCount();
		// 分页查询语句
		String sql = "select goodsid,price,introduce,goodsname,imageaddress,childcateid,parentcateid,stack,salenum from (select goods_t.*,rownum rn from goods_t where  rownum<=? and  parentcateid=? ) where  rn>? ";
		List<GoodsEntry> goodsList = query(sql, GoodsEntry.class,
				index + count, parentCateId, index);
		return goodsList;
	}

	public int getTotalCount(int parentCateId) {
		// sql语句
		String sql = "select count(*) totalCount from goods_t where parentcateid=?";
		List<PageBean> proCountList = query(sql, PageBean.class, parentCateId);
		// 返回商品数量
		if (proCountList.size() <= 0) {
			// 没有查到数据
			return 0;
		}
		// 查到数据返回结果
		return proCountList.get(0).getTotalCount();
	}

}

package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;

/**
 * 更具父类获取商品信息的接口
 * @author LFSenior
 *
 *下午12:23:41
 *
 */
public interface IGetProductByParentCateDao {
	/**
	 * 更具父类查找所有商品
	 * @param parentCateId 父类id
	 * @param pageBean 分页对象
	 * @return 返回商品消息
	 */
	public List<GoodsEntry> getProductParent(int parentCateId,PageBean pageBean);
	
	/**
	 * 获取商品总数
	 * @param parentCateId 父类id 
	 * @return 返回商品总数
	 */
	public int getTotalCount(int parentCateId);
}

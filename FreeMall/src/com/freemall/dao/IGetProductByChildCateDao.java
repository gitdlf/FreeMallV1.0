package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;

/**
 * 根据子类获取商品的接口
 * @author LFSenior
 *
 *下午12:24:49
 *
 */
public interface IGetProductByChildCateDao {
	/**
	 * 更具子类查找所有商品
	 * @param childCateId 子类id
	 * @param pageBean 分页对象
	 * @return 返回商品信息
	 */
	public List<GoodsEntry> getProductChild(int childCateId,PageBean pageBean);
	
	/**
	 * 获取商品总数
	 * @param childCateId 子类id
	 * @return
	 */
	public int getTotalCount(int childCateId);
}

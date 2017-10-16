package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;

/**
 * 获取分类型服务
 * @author LFSenior
 *
 *上午10:06:59
 *
 */
public interface IGetProductByCateService {
	/**
	 * 更具父类查找所有商品
	 * @param parentCateId 父类id
	 * @param pageBean 分页对象
	 * @return 返回商品消息
	 */
	public List<GoodsEntry> getProductParent(int parentCateId,PageBean pageBean);
	/**
	 * 更具子类查找所有商品
	 * @param childCateId 子类id
	 * @param pageBean 分页对象
	 * @return 返回商品信息
	 */
	public List<GoodsEntry> getProductChild(int childCateId,PageBean pageBean);
	
}

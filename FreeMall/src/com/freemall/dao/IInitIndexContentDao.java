package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;

/**
 * 获取主页商品信息的dao
 * @author LFSenior
 *
 *下午7:02:26
 *
 */
public interface IInitIndexContentDao {
	/**
	 * 更具父类别id获取6个主页商品
	 * @param parentCateId
	 * @return
	 */
	public List<GoodsEntry> getContentGoods(String parentCateId);
}

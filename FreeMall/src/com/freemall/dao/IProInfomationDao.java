package com.freemall.dao;

import com.freemall.dao.entry.GoodsEntry;

/**
 * 获取商品详情dao接口
 * @author LFSenior
 *
 *上午11:31:22
 *
 */
public interface IProInfomationDao {
	/**
	 * 根据id获取商品详情
	 * @param goodsId
	 * @return
	 */
	public GoodsEntry getProInfomation(String goodsId);
}

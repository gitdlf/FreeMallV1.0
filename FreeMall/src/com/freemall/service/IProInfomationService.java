package com.freemall.service;

import com.freemall.dao.entry.GoodsEntry;

/**
 * 获取商品详情服务
 * @author LFSenior
 *
 *上午11:28:32
 *
 */
public interface IProInfomationService {
	/**
	 * 根据id获取商品详情
	 * @param goodsId
	 * @return
	 */
	public GoodsEntry getProInfomation(String goodsId);
}

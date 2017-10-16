package com.freemall.dao;

import com.freemall.dao.entry.GoodsEntry;

/**
 * 更具商品id获取商品
 * @author LFSenior
 *
 *上午8:26:13
 *
 */
public interface IGetProByProIdDao {
	/**
	 * 根据商品id查询商品信息
	 * @param proId
	 * @return
	 */
	public GoodsEntry getProByProId(String proId);
}

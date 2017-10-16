package com.freemall.service.search;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.imp.ProInfomationDao;
import com.freemall.service.IProInfomationService;

/**
 * 获取商品详情实现类
 * @author LFSenior
 *
 *上午11:30:29
 *
 */
public class ProInfomationService implements IProInfomationService {

	/**
	 * 如果没有数据返回null
	 */
	public GoodsEntry getProInfomation(String goodsId) {
		return new ProInfomationDao().getProInfomation(goodsId);
	}

}

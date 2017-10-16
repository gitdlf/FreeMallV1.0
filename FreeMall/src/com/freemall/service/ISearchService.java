package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;


/**
 * 
 * 搜索的服务接口
 * @author LFSenior
 *
 *下午4:01:59
 *
 */
public interface ISearchService {
	/**
	 * 根据关键字搜索商品信息
	 * @param keyWords 关键字
	 * @param pageBean 分页信息
	 * @return
	 */
	public List<GoodsEntry> getGoodsBySearch(String keyWords,PageBean pageBean);
}

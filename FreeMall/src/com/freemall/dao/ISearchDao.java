package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;

/**
 * 搜索的dao接口
 * @author LFSenior
 *
 *下午4:05:35
 *
 */
public interface ISearchDao {
	/**
	 * 根据关键字搜索商品信息
	 * @param keyWords 关键字
	 * @param pageBean 分页信息
	 * @return
	 */
	public List<GoodsEntry> getGoodsBySearch(String keyWords,PageBean pageBean);
	
	
	/**
	 * 获取商品总数
	 * @param keyWords 关键字
	 * @return
	 */
	public int getTotalCount(String keyWords);
}

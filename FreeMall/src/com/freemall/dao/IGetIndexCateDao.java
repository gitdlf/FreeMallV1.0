package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.ParentCateEntry;

/**
 * 获取主页nav导航数据
 * @author LFSenior
 *
 *上午9:55:54
 *
 */
public interface IGetIndexCateDao {
	/**
	 * 获取主页nav的分类数据
	 * @return
	 */
	public List<ParentCateEntry> getIndexCateNav(); 
	

}

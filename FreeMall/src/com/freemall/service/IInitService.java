package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.BannerEntry;
import com.freemall.dao.entry.ParentCateEntry;

/**
 * 
 * 主页初始化接口
 * @author LFSenior
 *
 *下午2:51:19
 *
 */
public interface IInitService {
		
	
	/**
	 * 获取主页nav的分类数据
	 * @return
	 */
	public List<ParentCateEntry> getIndexCateNav(); 
	
	/**
	 * 获取主页banner数据
	 * @param path indexBannerConfig文件路径
	 * @return 返回封装好的BannerEntry数据
	 */
	public List<BannerEntry> getBannerDate(String path);
	
	
	/**
	 * 获取主页搜索框下的热词
	 * @param path hotKeyWordsConfig文件路径
	 * @return 返回热词的字符串集合
	 */
	public List<String> getHotKeywordDate(String path);
}

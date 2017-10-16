package com.freemall.service;

import java.util.List;

import com.freemall.dao.entry.IndexContentEntry;

/**
 * 主页中部内容更新内容
 * @author LFSenior
 *
 *下午6:39:38
 *
 */
public interface IInitContentService {
	/**
	 * 获取首页中部的信息
	 * @param path indexContentConfig.xml配置文档的路径
	 * @return
	 */
	public List<IndexContentEntry> getIndexContentList(String path);
}

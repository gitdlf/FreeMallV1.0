package com.freemall.dao;

import java.util.List;

/**
 * 热词初始化dao接口
 * @author LFSenior
 *
 *下午5:41:04
 *
 */
public interface IGetHotKeywordDao {
	/**
	 * 获取主页搜索框下的热词
	 * @param path hotKeyWordsConfig文件路径
	 * @return 返回热词的字符串集合
	 */
	public List<String> getHotKeywordDate(String path);
}

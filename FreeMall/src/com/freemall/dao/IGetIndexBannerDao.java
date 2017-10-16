package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.BannerEntry;

/**
 * 获取主页数据Dao接口
 * @author LFSenior
 *
 *上午9:08:39
 *
 */
public interface IGetIndexBannerDao {
	/**
	 * 获取主页banner数据
	 * @param path indexBannerConfig文件路径
	 * @return 返回封装好的BannerEntry数据
	 */
	public List<BannerEntry> getBannerDate(String path);
}

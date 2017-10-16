package com.freemall.service.init;

import java.util.List;

import com.freemall.dao.entry.BannerEntry;
import com.freemall.dao.entry.ParentCateEntry;
import com.freemall.dao.imp.GetHotKeywordDao;
import com.freemall.dao.imp.GetIndexBannerDao;
import com.freemall.dao.imp.GetIndexCateDao;
import com.freemall.service.IInitService;

/**
 * 主页初始化服务实现类
 * @author LFSenior
 *
 *上午9:55:07
 *
 */
public class InitService implements IInitService {

	public List<ParentCateEntry> getIndexCateNav() {
		return new GetIndexCateDao().getIndexCateNav();
	}

	public List<BannerEntry> getBannerDate(String path) {
		return new GetIndexBannerDao().getBannerDate(path);
	}

	public List<String> getHotKeywordDate(String path) {
		// TODO Auto-generated method stub
		return new GetHotKeywordDao().getHotKeywordDate(path);
	}


}

package com.freemall.service.search;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;
import com.freemall.dao.imp.SearchDao;
import com.freemall.service.ISearchService;

/**
 * 搜索服务的实现类
 * @author LFSenior
 *
 *下午4:04:03
 *
 */
public class SearchService implements ISearchService{

	public List<GoodsEntry> getGoodsBySearch(String keyWords,PageBean pageBean) {
		
		return new SearchDao().getGoodsBySearch(keyWords, pageBean);
	}

}

package com.freemall.service.search;

import java.util.List;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;
import com.freemall.dao.imp.GetProductByChildCateDao;
import com.freemall.dao.imp.GetProductByParentCateDao;
import com.freemall.service.IGetProductByCateService;

public class GetProductByCateService implements IGetProductByCateService{

	public List<GoodsEntry> getProductParent(int parentCateId, PageBean pageBean) {
		return new GetProductByParentCateDao().getProductParent(parentCateId, pageBean);
	}

	public List<GoodsEntry> getProductChild(int childCateId, PageBean pageBean) {
		return new GetProductByChildCateDao().getProductChild(childCateId, pageBean);
	}

}

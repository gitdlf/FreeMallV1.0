package com.freemall.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.freemall.dao.IGetIndexBannerDao;
import com.freemall.dao.entry.BannerEntry;
import com.freemall.util.CURDXml;
import com.freemall.util.XMLUtil;
import com.freemall.util.XMlReslutSetter;

/**
 * 获取主页轮播图数据实现dao
 * @author LFSenior
 *
 *上午9:09:18
 *
 */
public class GetIndexBannerDao extends CURDXml implements IGetIndexBannerDao {

	public List<BannerEntry> getBannerDate(String path) {
		final List<BannerEntry> bannerDateList=new ArrayList<BannerEntry>();
		try {
			query("//content", XMLUtil.read(path), new XMlReslutSetter() {
				
				public void setResult(List<Element> elements) {
					// TODO Auto-generated method stub
					//获取到contet这一级的Element对象
					for(Element element:elements){
						BannerEntry bannerEntry=new BannerEntry();
						//获取父类别
						bannerEntry.setParentCateId(element.elementText("parentCateId"));
						//获取图片地址
						bannerEntry.setImageAddress(element.elementText("imageAddress"));
						bannerDateList.add(bannerEntry);
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bannerDateList;
	}
	
	

}

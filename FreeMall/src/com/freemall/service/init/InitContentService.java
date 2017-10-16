package com.freemall.service.init;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.IndexContentEntry;
import com.freemall.dao.imp.InitIndexContentDao;
import com.freemall.service.IInitContentService;
import com.freemall.util.CURDXml;
import com.freemall.util.XMLUtil;
import com.freemall.util.XMlReslutSetter;

/**
 * 获取中部数据的初始化服务类
 * 
 * @author LFSenior
 * 
 *         下午6:43:32
 * 
 */
public class InitContentService extends CURDXml implements IInitContentService {

	
	public List<IndexContentEntry> getIndexContentList(String path) {
		final List<IndexContentEntry> INDEXCONTENTINFO = new ArrayList<IndexContentEntry>();
		try {
			query("//content", XMLUtil.read(path), new XMlReslutSetter() {
				
				@SuppressWarnings("unchecked")
				public void setResult(List<Element> elements) {
					for (Element element : elements) {
						IndexContentEntry indexContentEntry=new IndexContentEntry();
						//获取标题
						String title=element.elementText("title");
						//获取标签
						List<String> tags=new ArrayList<String>();
						List<Element> tagEle = element.elements("tag");
						for (Element elem : tagEle) {
							tags.add(elem.getText());
						}
						List<GoodsEntry> contentGoodsList = getContentGoods(element.elementText("parentCateId"));
						indexContentEntry.setTitle(title);
						indexContentEntry.setTags(tags);
						indexContentEntry.setGoodsList(contentGoodsList);
						INDEXCONTENTINFO.add(indexContentEntry);
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INDEXCONTENTINFO;
	}
	
	/**
	 * 获取商品实体的数据
	 * @param parentCateId 父类id
	 * @return
	 */
	public List<GoodsEntry> getContentGoods(String parentCateId){
		return new InitIndexContentDao().getContentGoods(parentCateId);
	}
}

package com.freemall.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.freemall.dao.IGetHotKeywordDao;
import com.freemall.util.CURDXml;
import com.freemall.util.XMLUtil;
import com.freemall.util.XMlReslutSetter;

/**
 * 获取热词的实现dao
 * @author LFSenior
 *
 *下午5:41:48
 *
 */
public class GetHotKeywordDao extends CURDXml implements IGetHotKeywordDao {

	public List<String> getHotKeywordDate(String path) {
		final List<String> hotKeywordList=new ArrayList<String>();
		try {
			query("//keyword", XMLUtil.read(path), new XMlReslutSetter() {
				
				public void setResult(List<Element> elements) {
					// TODO Auto-generated method stub
					//获取到contet这一级的Element对象
					for(Element element:elements){
						hotKeywordList.add(element.getText());
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotKeywordList;
	}

}

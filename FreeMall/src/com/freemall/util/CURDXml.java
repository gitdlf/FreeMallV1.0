package com.freemall.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 实现对xml的增删改查
 *需求：
 *	更具用户传入的xpath表达式，实现查询
 * @author LFSenior
 *
 *下午7:04:43
 *
 */
public class CURDXml {

	@SuppressWarnings("unchecked")
	public static void query(String xpath,Document doc,XMlReslutSetter setter){
		List<Element> elements = doc.selectNodes(xpath);
		setter.setResult(elements);
	}
	
	public static Document update(Document doc,XMLUpdateSetter setter){
		Element root = doc.getRootElement();
		setter.setUpdate(root);
		return doc;
	}
}

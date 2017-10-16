package com.freemall.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;

import com.freemall.util.CURDXml;
import com.freemall.util.XMLUtil;
import com.freemall.util.XMlReslutSetter;

public class XMLTest extends CURDXml {
	@Test
	public void test1() throws Exception{
		Document doc = XMLUtil.read("./src/com/freemall/test/indexContentConfig.xml");
		System.out.println(doc);
		query("//content", doc, new XMlReslutSetter() {
			
			@SuppressWarnings("unchecked")
			public void setResult(List<Element> elements) {
				for (Element element : elements) {
					List<Element> tags = element.elements("tag");
					for (Element element2 : tags) {
						System.out.println(element2.getText());
					}
				}
			}
		});
	}
}

package com.freemall.util;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml读写的工具类
 * @author LFSenior
 *
 *下午6:57:31
 *
 */
public class XMLUtil {
	/**
	 * 读取xml文档，返回document对象
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static Document read(String path) throws Exception{
		return new SAXReader().read(path);
	}
	
	/**
	 * 写到指定路径的xml文档
	 * @param doc
	 * @param path
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static void write(Document doc,String path) throws Exception{
		new XMLWriter(new FileOutputStream(path),new OutputFormat().createPrettyPrint()).write(doc);
	}
}

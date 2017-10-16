package com.freemall.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.freemall.dao.JdbcBase;

public class ImgDownload extends JdbcBase {

	// 批量执行脚本
	@Test
	public void thead() throws Exception {
		File doc = new File("./src/com/freemall/test/814");
		File[] listFiles = doc.listFiles();
		for (final File file : listFiles) {
			imgDownload(file);
		}
	}

	public void imgDownload(File file) throws Exception {
		// path格式./src/com/freemall/test/parentCate.txt
		// = new File("./src/com/freemall/test/7-29.log");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		while ((line = br.readLine()) != null) {
			// list.add(line);
			downImg(line);
		}
		br.close();
	}

	/*
	 * public void imgDownloadMore() throws Exception{ File file = new
	 * File("./src/com/freemall/test/2-6.log"); imgDownload(file); File file1 =
	 * new File("./src/com/freemall/test/2-7.log"); imgDownload(file1); File
	 * file2 = new File("./src/com/freemall/test/2-8.log"); imgDownload(file2);
	 * File file3 = new File("./src/com/freemall/test/2-9.log");
	 * imgDownload(file3); File file4 = new
	 * File("./src/com/freemall/test/2-10.log"); imgDownload(file4); }
	 */

	public void downImg(String line) throws IOException {
		String[] split = line.split("=");
		// 获取数据
		String imgUrl = split[0];// 图片地址
		double price = Double.parseDouble(split[1].substring(1));// 商品价格
		String proname = split[2];// 商品名
		String detail = split[3];// 商品描述
		int parentId = Integer.parseInt(split[4]);// 父类id
		int childId = Integer.parseInt(split[5]);// 子类id
		URL url = new URL(imgUrl);
		String fileName = new File(url.getFile()).getName();
		String dbPath = "/images/product/" + parentId + "/" + childId + "/"
				+ fileName;
		String path = "D:" + dbPath;
		File file = new File(path);
		file.getParentFile().mkdirs();

		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(file));
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf, 0, len);
			bos.flush();
		}
		bos.close();
		bis.close();
		System.out.println(fileName + "下载成功");
		insertProduct(price, detail, proname, dbPath, childId, parentId);
	}

	public void insertProduct(Object... params) {
		String sql = "insert into goods_t (goodsid,price,introduce,goodsname,imageaddress,childcateid,createauthor,parentcateid,stack) values (goods_s.nextval,?,?,?,?,?,'lfsenior',?,100)";
		update(sql, params);
	}
}

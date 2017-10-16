package com.freemall.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;



public class Download {
	public void downImgStart(String path,String title,String imgs[]) throws IOException{
		long time=new Date().getTime();
		for (int i=0;i<imgs.length;i++) {
			String fileName=i+"x_"+time+".jpg";
			System.out.println(imgs[i]);
			if(imgs[i].endsWith(".jpg")){
				downImg(imgs[i], path, title, fileName);
			}
		}
	}
	
	public void downImg(String urlPath,String path,String title,String fileName) throws IOException{
		try {
			URL url=new URL(urlPath);
			title=title.replace(" ", "");
			title=title.trim();
			title=title.replace("|", "-");
			File file=new File(path+title+"\\"+fileName);
			file.getParentFile().mkdirs();
			BufferedInputStream bis=new BufferedInputStream(url.openStream());
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			byte[] buf=new byte[1024];
			int len=0;
			while((len=bis.read(buf))!=-1){
				bos.write(buf, 0, len);
				bos.flush();
			}
			bos.close();
			bis.close();
			System.out.println(fileName+"下载成功");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

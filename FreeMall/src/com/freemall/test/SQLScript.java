package com.freemall.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import com.freemall.dao.JdbcBase;

public class SQLScript extends JdbcBase {
	@Test
	public void addParentCate() throws Exception{
		String sql="insert into parentcate_t (parentcateid,parentcatename,craeteauthor) values (parentcate_s.nextval,?,'lfsenior')";
		//path格式./src/com/freemall/test/parentCate.txt
		add(sql,"./src/com/freemall/test/parentCate.txt");
	}
	
	
	@Test
	public void addChildCate() throws Exception{
		String sql="insert into childcate_t (childcateid,childcatename,parentcateid,craeteauthor) values (childcate_s.nextval,?,?,'lfsenior')";
		add(sql,"./src/com/freemall/test/childCate.txt");
	}
	
	
	public void add(String sql,String path) throws Exception{
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line="";
		while((line=br.readLine())!=null){
			if("".equals(line.trim())){
				continue;
			}
//			String[] param = line.split(":");
//			update(sql, param);
		}
	}
	
	
}

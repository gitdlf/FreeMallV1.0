package com.freemall.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc的工具类，提供获取连接对象和关闭对象的操作
 * @author LFSenior
 *
 *下午7:04:44
 *
 */
public class JDBCUtil {
	
	/**
	 * 传统获取连接方法
	 */
/*	
 *  private static Connection conn;
	private static String userName;
	private static String passWord;
	private static String driver;
	private static String url;
 * 
 * static{
		Properties pro=new Properties();
		try {
			pro.load(JDBCUtil.class.getResourceAsStream("./jdbcinfo.properties"));
			userName=pro.getProperty("userName");
			passWord=pro.getProperty("passWord");
			driver=pro.getProperty("driver");
			url=pro.getProperty("url");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	*//**
	 * 获取Connection连接对象方法
	 * @return
	 *//*
	public static Connection getConnection(){
		
		try {
			conn=DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	*/
	private static ComboPooledDataSource dataSource;
	static{
		/**
		 * 使用默认配置的数据库连接池
		 */
		dataSource=new ComboPooledDataSource();
	}
	
	
	/**
	 * 利用利用c3p0连接池技术获取连接对象
	 * @return
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("连接池异常");
		}
	}
	
	
	/**
	 * 提供关闭所有对象的功能
	 * @param conn
	 * @param state
	 * @param rs
	 */
	public static void close(Connection conn,Statement state,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(state!=null){
				state.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * 对象数据复制
	 * 将数据源对象的属性值，复制给目标对象
	 * 数据源对象与目标对象属于同一个类
	 * @param desc 目标对象
	 * @param orig 数据源对象
	 */
	public static void objectDateCopy(Object desc,Object orig){
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			BeanUtils.copyProperties(desc, orig);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

package com.freemall.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.freemall.util.JDBCUtil;

/**
 * 利用DBUtils做的一个CURD的基础类，提供两个基本方法
 * 
 * @author LFSenior
 * 
 *         下午7:18:45
 * 
 */
public class JdbcBase {
	/**
	 * 增删改的基础类
	 * 
	 * @param sql
	 *            操作的sql语句
	 * @param params
	 *            可变参数列表
	 * @return 影响的行数
	 */
	public Integer update(String sql, Object... params) {
		// 受影响的行数
		int effectionLine = 0;
		Connection conn = JDBCUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			effectionLine = queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			System.out.println("更新异常------------------------");
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				System.out.println("更新关闭连接对象异常------------------------");
				e.printStackTrace();
			}
		}
		return effectionLine;
	}

	/**
	 * 所有查询的基础类
	 * 
	 * @param sql
	 *            要查询的sql语句
	 * @param clazz
	 *            返回对象的字节码文件
	 * @param params
	 *            可变参数列表
	 * @return 返回获取的的对象的集合
	 */
	public <T> List<T> query(String sql, Class<T> clazz, Object... params) {
		List<T> resultObjectList = new ArrayList<T>();
		Connection conn = JDBCUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			resultObjectList = queryRunner.query(conn, sql,
					new BeanListHandler<T>(clazz), params);
		} catch (SQLException e) {
			System.out.println("查询异常------------------------");
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				System.out.println("更新关闭异常------------------------");
				e.printStackTrace();
			}
		}
		return resultObjectList;

	}

	/**
	 * 所有批处理的基础方法
	 * @param sql sql语句
	 * @param params 批处理的二维数组
	 * @return 返回每条语句影响的行数
	 */
	public int[] batch(String sql, Object[][] params) {
		// 受影响的行数
		int[] effectionLine = null;
		Connection conn = JDBCUtil.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		try {
			effectionLine = queryRunner.batch(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return effectionLine;
	}
}

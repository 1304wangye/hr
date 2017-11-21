package com.icss.hr.common;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.bcel.internal.generic.NEW;

import oracle.jdbc.driver.OracleDriver;

/**
 * 数据库连接工具类
 * 
 * @author DLETC
 *
 */
public class DbUtil {

	// 数据源对象
	private static ComboPooledDataSource dataSource;
	
	//本地线程对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	// 设置连接池参数
	static {
		dataSource = new ComboPooledDataSource();

		try {
			// 数据库连接相关参数
			dataSource.setUser("myhr");// 用户名
			dataSource.setPassword("myhr");// 密码
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");// 连接字符串
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");// 注册驱动

			// 连接池相关参数
			dataSource.setInitialPoolSize(10);// 初始连接数
			dataSource.setMaxPoolSize(20);// 最大连接数
			dataSource.setMinPoolSize(10);// 最小连接数
			dataSource.setMaxIdleTime(60);// 最大空闲时间60秒，连接对象60秒内没有使用才会被销毁

		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过连接池对象返回数据库连接
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		//从本地线程取出连接对象
		Connection conn = threadLocal.get();
		
		//如果本地线程中没有连接对象，那么从连接池中获得一个空闲连接,存储到本地线程中
		if (conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		
		//测试语句，返回当前连接池中剩余的空闲连接数
		System.out.println("获得数据库连接，剩余的空闲连接数："+dataSource.getNumIdleConnections());
		
		return conn;//从连接池中随机返回一个空闲连接
	}
	
	/**
	 * 统一关闭连接
	 */
	public static void close() {
		
		//从本地线程中取出连接
		Connection conn = threadLocal.get();
		
		try {
			//如果连接不为空且没有被关闭
			if (conn!=null&&!conn.isClosed()) {
				//关闭连接
				conn.close();
				//接触存储
				threadLocal.set(null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * static { try { // 注册驱动 DriverManager.registerDriver(new OracleDriver());
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 */
	/**
	 * 利用简单工厂模式，返回数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	/*
	 * public static Connection getConnection() throws SQLException {
	 * 
	 * String url = "jdbc:oracle:thin:@localhost:1521:xe"; String user = "myhr";
	 * String password = "myhr";
	 * 
	 * Connection conn = DriverManager.getConnection(url, user, password);
	 * 
	 * return conn;
	 * 
	 * }
	 */
}

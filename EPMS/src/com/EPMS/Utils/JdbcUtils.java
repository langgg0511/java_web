package com.EPMS.Utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	//初始化连接池
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("epms");
	
	//提供ThreadLocal用于线程中绑定连接
	private static ThreadLocal<Connection> local=new ThreadLocal<Connection>();
	
	//获得连接
	public static Connection getConnection() throws SQLException {
		//从local中获得
		Connection conn=local.get();
		
		//如果没有，从连接池中获得，之后保存到local中
		if(conn==null) {
			conn=dataSource.getConnection();
			local.set(conn);
		}
		
		//返回
		return conn;
	}
	
	//获得数据源
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
	
}

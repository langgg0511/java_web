package com.EPMS.Utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	//��ʼ�����ӳ�
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("epms");
	
	//�ṩThreadLocal�����߳��а�����
	private static ThreadLocal<Connection> local=new ThreadLocal<Connection>();
	
	//�������
	public static Connection getConnection() throws SQLException {
		//��local�л��
		Connection conn=local.get();
		
		//���û�У������ӳ��л�ã�֮�󱣴浽local��
		if(conn==null) {
			conn=dataSource.getConnection();
			local.set(conn);
		}
		
		//����
		return conn;
	}
	
	//�������Դ
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
	
}

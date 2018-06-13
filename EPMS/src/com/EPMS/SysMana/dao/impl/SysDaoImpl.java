package com.EPMS.SysMana.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.EPMS.SysMana.dao.SysDao;
import com.EPMS.SysMana.po.User;
import com.EPMS.Utils.JdbcUtils;

public class SysDaoImpl implements SysDao{

	//����Ƿ�����˻�
	@Override
	public User checkUserById(String number) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where number=?";
		Object[] params= {number};
		User user= qr.query(sql, new BeanHandler<User>(User.class),params);
		return user;
	}

	//����˻�
	@Override
	public void addAccount(String number, String password) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into user (number,password) values(?,?)";
		Object[] params= {number,password};
		qr.update(sql,params);
	}

	//ɾ���˻� 
	@Override
	public void deleteAccountById(String number) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="delete from user where number=?";
		Object[] params= {number};
		qr.update(sql,params);
		
	}

	//����Ȩ��
	@Override
	public void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		//��ȫ����Ϊ0
		String sql="update jobdetail set auth_state=? where did=? and jid=?";
		Object[] params= {0,department,job};
		qr.update(sql,params);
		
		for(String str:authorities) {
			String sql1="update jobdetail set auth_state=? where did=? and jid=? and authority=?";
			Object[] params1= {1,department,job,str.toString()};
			qr.update(sql1,params1);
		}
	}

}

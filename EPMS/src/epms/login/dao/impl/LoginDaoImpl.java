package epms.login.dao.impl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import epms.login.dao.LoginDao;
import epms.login.entity.User;
import epms.z_util.JdbcUtils;

public class LoginDaoImpl implements LoginDao{	
	public boolean queryUser(User user) {
		boolean flag=false;
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from user where number=? and password=?";
		try {
			User u=(User)qr.query(sql, new BeanHandler(User.class),new Object[]{user.getNumber(),user.getPassword()});
			if(u!=null){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) {
	/*	User user=new User("001","002");
		LoginDaoImpl dao=new LoginDaoImpl();
		boolean flag=dao.queryUser(user);
		System.out.println(flag);*/
	}
}

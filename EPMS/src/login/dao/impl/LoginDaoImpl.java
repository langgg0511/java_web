package login.dao.impl;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.EPMS.Utils.JdbcUtils;

import login.entity.User;
import login.dao.LoginDao;


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
}

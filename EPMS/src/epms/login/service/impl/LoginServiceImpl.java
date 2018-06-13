package epms.login.service.impl;

import epms.login.dao.LoginDao;
import epms.login.dao.impl.LoginDaoImpl;
import epms.login.entity.User;
import epms.login.service.LoginService;
import org.apache.commons.dbutils.ResultSetHandler;
public class LoginServiceImpl implements LoginService {

	private LoginDao dao=new LoginDaoImpl();
	@Override
	public  boolean login(User user) {
		boolean flag=dao.queryUser(user);
		return flag;
	}
	public static void main(String[] args) {
	/*	User user=new User("001","001");
		LoginServiceImpl service=new LoginServiceImpl();
		boolean flag=service.queryUser(user);
		System.out.println(flag);*/
	}
}

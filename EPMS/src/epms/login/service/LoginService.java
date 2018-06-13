package epms.login.service;

import epms.login.entity.User;

public interface LoginService {
	//查询用户表
	public boolean login(User user);
}	

package epms.login.dao;

import epms.login.entity.User;

public interface LoginDao {
	/**
	 * 查询用户表是否存在输入用户
	 */
	public boolean queryUser(User user);
}

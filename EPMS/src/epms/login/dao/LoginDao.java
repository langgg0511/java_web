package epms.login.dao;

import epms.login.entity.User;

public interface LoginDao {
	/**
	 * ��ѯ�û����Ƿ���������û�
	 */
	public boolean queryUser(User user);
}

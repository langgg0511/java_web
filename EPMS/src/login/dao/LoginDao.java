package login.dao;

import login.entity.User;

public interface LoginDao {
	/**
	 * ��ѯ�û����Ƿ���������û�
	 */
	public boolean queryUser(User user);
}

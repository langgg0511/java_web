package com.EPMS.SysMana.dao;

import com.EPMS.SysMana.po.User;

public interface SysDao {

	//����˻��Ƿ����
	User checkUserById(String number) throws Exception;

	//����˻�
	void addAccount(String number, String password) throws Exception;

	//ɾ���˻�
	void deleteAccountById(String number) throws Exception;

	//����Ȩ��
	void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception;
}

package com.EPMS.SysMana.service;

public interface SysService {

	//�ж��˻��Ƿ���ڲ����
	boolean checkAccount(String number, String password) throws Exception;

	//ɾ���˻�
	boolean deleteAccountById(String number)throws Exception;

	//����Ȩ��
	void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception;

}

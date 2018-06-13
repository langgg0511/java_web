package com.EPMS.SysMana.service;

public interface SysService {

	//判断账户是否存在并添加
	boolean checkAccount(String number, String password) throws Exception;

	//删除账户
	boolean deleteAccountById(String number)throws Exception;

	//更新权限
	void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception;

}

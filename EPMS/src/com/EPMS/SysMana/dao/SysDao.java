package com.EPMS.SysMana.dao;

import com.EPMS.SysMana.po.User;

public interface SysDao {

	//检查账户是否存在
	User checkUserById(String number) throws Exception;

	//添加账户
	void addAccount(String number, String password) throws Exception;

	//删除账户
	void deleteAccountById(String number) throws Exception;

	//更新权限
	void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception;
}

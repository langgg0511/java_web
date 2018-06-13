package com.EPMS.SysMana.service.impl;

import com.EPMS.SysMana.dao.SysDao;
import com.EPMS.SysMana.dao.impl.SysDaoImpl;
import com.EPMS.SysMana.po.User;
import com.EPMS.SysMana.service.SysService;

public class SysServiceImpl implements SysService{

	private SysDao dao=new SysDaoImpl();
	
	@Override
	public boolean checkAccount(String number, String password) throws Exception {
		User user =dao.checkUserById(number);
		if(user!=null) {
			return false;
		}else {
			//¥Ê»Î’Àªß
			dao.addAccount(number,password);
			return true;
		}
	}

	@Override
	public boolean deleteAccountById(String number) throws Exception {
		User user =dao.checkUserById(number);
		if(user==null) {
			return false;
		}else {
			dao.deleteAccountById(number);
			return true;
		}
	}

	@Override
	public void updateAuthority(Integer department, Integer job, String[] authorities) throws Exception {
		dao.updateAuthority(department,job,authorities);
	}

}

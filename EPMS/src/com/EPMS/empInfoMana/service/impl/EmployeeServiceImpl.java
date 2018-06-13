package com.EPMS.empInfoMana.service.impl;

import java.util.List;

import com.EPMS.empInfoMana.dao.EmployeeDao;
import com.EPMS.empInfoMana.dao.impl.EmployeeDaoImpl;
import com.EPMS.empInfoMana.service.EmployeeService;
import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao emplDao=new EmployeeDaoImpl();
	//获取部门信息
	@Override
	public List<Department> getDepart() throws Exception {
		return emplDao.getDepart();
	}

	//获取岗位信息
	@Override
	public List<Job> getJob() throws Exception {
		return emplDao.getJob();
	}

	//更新用户信息
	@Override
	public void updateEmployeeInfo(EmployeeInfoVo vo) throws Exception {
		//获取部门id
		Department depart=emplDao.getDepartIdByName(vo.getDepartment().getDname());
		//获取岗位id
		Job job=emplDao.getJobIdByName(vo.getJob().getJname());
		//更新
		emplDao.updateEmployeeInfo(vo,depart,job);
	}
	
}

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
	//��ȡ������Ϣ
	@Override
	public List<Department> getDepart() throws Exception {
		return emplDao.getDepart();
	}

	//��ȡ��λ��Ϣ
	@Override
	public List<Job> getJob() throws Exception {
		return emplDao.getJob();
	}

	//�����û���Ϣ
	@Override
	public void updateEmployeeInfo(EmployeeInfoVo vo) throws Exception {
		//��ȡ����id
		Department depart=emplDao.getDepartIdByName(vo.getDepartment().getDname());
		//��ȡ��λid
		Job job=emplDao.getJobIdByName(vo.getJob().getJname());
		//����
		emplDao.updateEmployeeInfo(vo,depart,job);
	}
	
}

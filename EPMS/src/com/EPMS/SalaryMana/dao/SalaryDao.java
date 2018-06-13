package com.EPMS.SalaryMana.dao;

import java.util.List;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;
import com.EPMS.reportMana.po.EmployeeInfo;


public interface SalaryDao {

	//添加工资信息
	void addSalaryInfo(PersonalSalary ps) throws Exception;

	//查找工资信息
	PersonalSalary findPersonalSalary(Integer eid, Integer year, Integer month) throws Exception;

	//获取工资信息
	List<PersonalSalary> getPersonalSalary()throws Exception;

	//获取用户信息
	EmployeeInfo getEmployeeInfoById(int pid)throws Exception;

	//删除工资信息
	void deleteSalary(Integer pid, Integer year, Integer month) throws Exception;

	//查询单个工资信息
	List<PersonalSalary> getOneInfo(Integer pid)throws Exception;

	//修改工资信息
	void updateSalary(PersonalSalary ps)throws Exception;
	
}

package com.EPMS.SalaryMana.service;

import java.util.List;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;


public interface SalaryService {

	//判断输入月份是否存在
	
	boolean isInfoExist(Integer eid,Integer year,Integer month) throws Exception;
	//添加工资信息
	void addSalaryInfo(PersonalSalary ps) throws Exception;
	
	//获取工资信息
	List<PersonalSalaryVo> getPersonalSalaryVo()throws Exception;
	//删除工资信息
	void deleteSalary(Integer pid, Integer year, Integer month) throws Exception;
	//查询单个工资信息
	List<PersonalSalaryVo> getOneInfo(Integer pid) throws Exception;
	//修改工资信息
	void updateSalary(PersonalSalary ps)throws Exception;


}

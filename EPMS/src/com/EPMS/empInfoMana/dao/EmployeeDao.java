package com.EPMS.empInfoMana.dao;

import java.util.List;

import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;

public interface EmployeeDao {

	List<Department> getDepart() throws Exception;

	List<Job> getJob() throws Exception;

	void updateEmployeeInfo(EmployeeInfoVo vo, Department depart, Job job) throws Exception;

	Department getDepartIdByName(String dname)throws Exception;

	Job getJobIdByName(String jname) throws Exception;


}

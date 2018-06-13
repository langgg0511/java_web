package com.EPMS.empInfoMana.service;

import java.util.List;

import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;

public interface EmployeeService {

	List<Department> getDepart() throws Exception;

	List<Job> getJob()throws Exception;

	void updateEmployeeInfo(EmployeeInfoVo vo)throws Exception;

}

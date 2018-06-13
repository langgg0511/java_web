package com.EPMS.reportMana.service;

import java.util.List;

import com.EPMS.reportMana.po.AttendanceVo;
import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.PersonalsalaryVo;

public interface ReportService {

	//查询职工信息表
	List<EmployeeInfoVo> getEmployeeInfo() throws Exception;

	//查询工资信息表
	public List<PersonalsalaryVo> getSalary() throws Exception;

	//查询员工考勤表
	List<AttendanceVo> getAttend() throws Exception;

	//工资信息报表月份查询
	List<PersonalsalaryVo> getSalaryInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception;

	//考勤报表月份查询
	List<AttendanceVo> getAttendInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception;
}

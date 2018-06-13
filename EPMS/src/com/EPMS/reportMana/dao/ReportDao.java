package com.EPMS.reportMana.dao;

import java.util.List;

import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.Job;
import com.EPMS.reportMana.po.Personalsalary;
import com.EPMS.reportMana.po.Attendance;
import com.EPMS.reportMana.po.Department;

public interface ReportDao {

	//查询职工信息表
	List<EmployeeInfo> getEmployeeInfo() throws Exception;
	//查询工资信息表
	public List<Personalsalary> getSalary() throws Exception;
	
	//查询员工考勤表
	List<Attendance> getAttend()throws Exception;
	
	//通过id查信息
	EmployeeInfo getEmployeeInfoById(int id) throws Exception;
	
	//查询job
	Job getJob(int job) throws Exception;
	//查询department
	Department getDepart(int depart) throws Exception;
	//只查一年的工资信息
	List<Personalsalary> getSalaryInOneYear(Integer startYear, Integer startMonth, Integer endMonth) throws Exception;
	//查询两年工资信息
	List<Personalsalary> getSalaryInTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) throws Exception;
	//查询两年以上工资信息
	List<Personalsalary> getSalaryOverTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) throws Exception;
	//只查一年的考勤信息
	List<Attendance> getAttendInOneYear(Integer startYear, Integer startMonth, Integer endMonth) throws Exception;
	//查询两年考勤信息
	List<Attendance> getAttendInTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth)
			throws Exception;
	//查询两年以上考勤信息
	List<Attendance> getAttendOverTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth)
			throws Exception;
}

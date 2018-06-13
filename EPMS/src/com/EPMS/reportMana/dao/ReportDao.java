package com.EPMS.reportMana.dao;

import java.util.List;

import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.Job;
import com.EPMS.reportMana.po.Personalsalary;
import com.EPMS.reportMana.po.Attendance;
import com.EPMS.reportMana.po.Department;

public interface ReportDao {

	//��ѯְ����Ϣ��
	List<EmployeeInfo> getEmployeeInfo() throws Exception;
	//��ѯ������Ϣ��
	public List<Personalsalary> getSalary() throws Exception;
	
	//��ѯԱ�����ڱ�
	List<Attendance> getAttend()throws Exception;
	
	//ͨ��id����Ϣ
	EmployeeInfo getEmployeeInfoById(int id) throws Exception;
	
	//��ѯjob
	Job getJob(int job) throws Exception;
	//��ѯdepartment
	Department getDepart(int depart) throws Exception;
	//ֻ��һ��Ĺ�����Ϣ
	List<Personalsalary> getSalaryInOneYear(Integer startYear, Integer startMonth, Integer endMonth) throws Exception;
	//��ѯ���깤����Ϣ
	List<Personalsalary> getSalaryInTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) throws Exception;
	//��ѯ�������Ϲ�����Ϣ
	List<Personalsalary> getSalaryOverTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) throws Exception;
	//ֻ��һ��Ŀ�����Ϣ
	List<Attendance> getAttendInOneYear(Integer startYear, Integer startMonth, Integer endMonth) throws Exception;
	//��ѯ���꿼����Ϣ
	List<Attendance> getAttendInTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth)
			throws Exception;
	//��ѯ�������Ͽ�����Ϣ
	List<Attendance> getAttendOverTwoYear(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth)
			throws Exception;
}

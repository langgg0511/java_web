package com.EPMS.reportMana.service;

import java.util.List;

import com.EPMS.reportMana.po.AttendanceVo;
import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.PersonalsalaryVo;

public interface ReportService {

	//��ѯְ����Ϣ��
	List<EmployeeInfoVo> getEmployeeInfo() throws Exception;

	//��ѯ������Ϣ��
	public List<PersonalsalaryVo> getSalary() throws Exception;

	//��ѯԱ�����ڱ�
	List<AttendanceVo> getAttend() throws Exception;

	//������Ϣ�����·ݲ�ѯ
	List<PersonalsalaryVo> getSalaryInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception;

	//���ڱ����·ݲ�ѯ
	List<AttendanceVo> getAttendInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception;
}

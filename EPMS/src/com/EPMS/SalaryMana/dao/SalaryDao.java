package com.EPMS.SalaryMana.dao;

import java.util.List;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;
import com.EPMS.reportMana.po.EmployeeInfo;


public interface SalaryDao {

	//��ӹ�����Ϣ
	void addSalaryInfo(PersonalSalary ps) throws Exception;

	//���ҹ�����Ϣ
	PersonalSalary findPersonalSalary(Integer eid, Integer year, Integer month) throws Exception;

	//��ȡ������Ϣ
	List<PersonalSalary> getPersonalSalary()throws Exception;

	//��ȡ�û���Ϣ
	EmployeeInfo getEmployeeInfoById(int pid)throws Exception;

	//ɾ��������Ϣ
	void deleteSalary(Integer pid, Integer year, Integer month) throws Exception;

	//��ѯ����������Ϣ
	List<PersonalSalary> getOneInfo(Integer pid)throws Exception;

	//�޸Ĺ�����Ϣ
	void updateSalary(PersonalSalary ps)throws Exception;
	
}

package com.EPMS.SalaryMana.service;

import java.util.List;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;


public interface SalaryService {

	//�ж������·��Ƿ����
	
	boolean isInfoExist(Integer eid,Integer year,Integer month) throws Exception;
	//��ӹ�����Ϣ
	void addSalaryInfo(PersonalSalary ps) throws Exception;
	
	//��ȡ������Ϣ
	List<PersonalSalaryVo> getPersonalSalaryVo()throws Exception;
	//ɾ��������Ϣ
	void deleteSalary(Integer pid, Integer year, Integer month) throws Exception;
	//��ѯ����������Ϣ
	List<PersonalSalaryVo> getOneInfo(Integer pid) throws Exception;
	//�޸Ĺ�����Ϣ
	void updateSalary(PersonalSalary ps)throws Exception;


}

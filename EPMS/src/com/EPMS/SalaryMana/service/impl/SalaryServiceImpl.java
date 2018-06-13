package com.EPMS.SalaryMana.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.EPMS.SalaryMana.dao.SalaryDao;
import com.EPMS.SalaryMana.dao.impl.SalaryDaoImpl;
import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;
import com.EPMS.SalaryMana.service.SalaryService;
import com.EPMS.reportMana.po.EmployeeInfo;

public class SalaryServiceImpl implements SalaryService {

	private SalaryDao salaryDao=new SalaryDaoImpl();

	//�ж������·��Ƿ����
	@Override
	public boolean isInfoExist(Integer eid,Integer year,Integer month) throws Exception {
		PersonalSalary ps=salaryDao.findPersonalSalary(eid,year,month);
		//֤������
		if(ps!=null) {
			return false;
		}else return true;
	}

	//��ӹ�����Ϣ
	@Override
	public void addSalaryInfo(PersonalSalary ps) throws Exception {
		salaryDao.addSalaryInfo(ps);
	}

	//��ȡ������Ϣ
	@Override
	public List<PersonalSalaryVo> getPersonalSalaryVo() throws Exception {
		//��ȡpersonalsalary�����Ϣ
		List<PersonalSalary> ps=salaryDao.getPersonalSalary();
		
		List<PersonalSalaryVo> psVo=new ArrayList<>();
		for(int i=0;i<ps.size();i++) {
			PersonalSalaryVo personalSalaryVo=new PersonalSalaryVo();
			int pid=ps.get(i).getPid();
			EmployeeInfo employeeinfo=salaryDao.getEmployeeInfoById(pid);
			//��ȡ����
			personalSalaryVo.setName(employeeinfo.getName());
			personalSalaryVo.setPersonalSalary(ps.get(i));
			
			psVo.add(personalSalaryVo);
		}
		
		return psVo;
	}

	//ɾ��������Ϣ
	@Override
	public void deleteSalary(Integer pid, Integer year, Integer month) throws Exception {
		salaryDao.deleteSalary(pid,year,month);
	}

	//��ѯ����������Ϣ
	@Override
	public List<PersonalSalaryVo> getOneInfo(Integer pid) throws Exception {
		List<PersonalSalary> ps=salaryDao.getOneInfo(pid);
		EmployeeInfo employeeinfo=salaryDao.getEmployeeInfoById(pid);
		List<PersonalSalaryVo> list=new ArrayList<>();
		for(int i=0;i<ps.size();i++) {
			PersonalSalaryVo psVo=new PersonalSalaryVo();
			psVo.setName(employeeinfo.getName());
			psVo.setPersonalSalary(ps.get(i));
			list.add(psVo);
		}
		return list;
	}

	//�޸Ĺ�����Ϣ
	@Override
	public void updateSalary(PersonalSalary ps) throws Exception {
		salaryDao.updateSalary(ps);
	}
	

}

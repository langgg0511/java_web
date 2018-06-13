package epms.b_empInfoMana.service;

import java.util.List;

import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;

public interface EmpInfoService {
	/**
	 * �鿴Ա����Ϣ
	 */
	public List<Employee> queryEmpInfo();

	/**
	 * ����Ա����Ϣ
	 */
	public int addEmp(EmployeeInfo emp);
	/**
	 * ɾ��Ա����Ϣ
	 */
	public int deleteEmp(EmployeeInfo emp);
	/**
	 * �޸�Ա����Ϣ
	 */
	public int updateEmp(EmployeeInfo emp);
	/**
	 * ��ѯ���ű����Ϣ
	 */
	public List<Department> queryDeptInfo();
	/**
	 * ��ѯְλ�����Ϣ
	 */
	public List<Job> queryJobInfo();
}

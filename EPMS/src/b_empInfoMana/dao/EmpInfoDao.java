package b_empInfoMana.dao;

import java.util.List;

import b_empInfoMana.entity.Department;
import b_empInfoMana.entity.Employee;
import b_empInfoMana.entity.EmployeeInfo;
import b_empInfoMana.entity.Job;



public interface EmpInfoDao {
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
	 * ���ӡ�ɾ�����޸�Ա��ʱ���ж����ݿ����Ƿ��и�Ա��
	 * ����У����ܽ����ظ���Ӳ���
	 * ���û�У����ܽ���ɾ�����޸Ĳ���
	 */
	public boolean judge(EmployeeInfo emp);
	/**
	 * ��ѯ���ű����Ϣ
	 */
	public List<Department> queryDeptInfo();
	/**
	 * ��ѯְλ�����Ϣ
	 */
	public List<Job> queryJobInfo();
}

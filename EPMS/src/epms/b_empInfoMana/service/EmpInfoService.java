package epms.b_empInfoMana.service;

import java.util.List;

import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;

public interface EmpInfoService {
	/**
	 * 查看员工信息
	 */
	public List<Employee> queryEmpInfo();

	/**
	 * 增加员工信息
	 */
	public int addEmp(EmployeeInfo emp);
	/**
	 * 删除员工信息
	 */
	public int deleteEmp(EmployeeInfo emp);
	/**
	 * 修改员工信息
	 */
	public int updateEmp(EmployeeInfo emp);
	/**
	 * 查询部门表的信息
	 */
	public List<Department> queryDeptInfo();
	/**
	 * 查询职位表的信息
	 */
	public List<Job> queryJobInfo();
}

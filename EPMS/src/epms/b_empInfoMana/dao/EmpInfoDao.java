package epms.b_empInfoMana.dao;

import java.util.List;

import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;



public interface EmpInfoDao {
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
	 * 增加、删除、修改员工时，判断数据库中是否有该员工
	 * 如果有，则不能进行重复添加操作
	 * 如果没有，则不能进行删除和修改操作
	 */
	public boolean judge(EmployeeInfo emp);
	/**
	 * 查询部门表的信息
	 */
	public List<Department> queryDeptInfo();
	/**
	 * 查询职位表的信息
	 */
	public List<Job> queryJobInfo();
}

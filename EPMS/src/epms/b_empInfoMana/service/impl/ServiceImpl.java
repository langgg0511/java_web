package epms.b_empInfoMana.service.impl;

import java.util.List;

import epms.b_empInfoMana.dao.impl.DaoImpl;
import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;
import epms.b_empInfoMana.service.EmpInfoService;

public class ServiceImpl implements EmpInfoService{
	/**
	 * 查看员工信息
	 */
	@Override
	public List<Employee> queryEmpInfo() {
		DaoImpl daoImpl=new DaoImpl();		
		return daoImpl.queryEmpInfo();
	}
	/**
	 * 增加员工信息
	 */
	@Override
	public int addEmp(EmployeeInfo emp) {
		//1.判断数据库中是否已经存在该员工,存在则返回true，不存在则返回false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//如果flag为true，则数据库中存在该员工，不可以进行添加操作
			return 0;
		}else{//如果flag为false，则数据库中不存在该员工，可以进行添加操作
			return(daoImpl.addEmp(emp));//添加成功则返回1，否则返回0
		}

	}
	/**
	 * 删除员工信息
	 */
	@Override
	public int deleteEmp(EmployeeInfo emp) {
		//1.判断数据库中是否已经存在该员工,存在则返回true，不存在则返回false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//如果flag为true，则数据库中存在该员工，可以进行删除操作
			return (daoImpl.deleteEmp(emp));//删除成功则返回1，否则返回0
		}else{//如果flag为false，则数据库中不存在该员工，无法进行删除操作
			return 0;
		}
	}
	/**
	 * 修改员工信息
	 */
	@Override
	public int updateEmp(EmployeeInfo emp) {
		//1.判断数据库中是否已经存在该员工,存在则返回true，不存在则返回false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//如果flag为true，则数据库中存在该员工，可以进行修改操作
			return (daoImpl.updateEmp(emp));//修改成功则返回1，否则返回0
		}else{//如果flag为false，则数据库中不存在该员工，无法进行修改操作
			return 0;
		}
	}
	/**
	 * 查询部门表的信息
	 */
	@Override
	public List<Department> queryDeptInfo() {
		DaoImpl daoImpl = new DaoImpl();
		return daoImpl.queryDeptInfo();
	}
	/**
	 * 查询工作表的信息
	 */
	@Override
	public List<Job> queryJobInfo() {
		DaoImpl daoImpl = new DaoImpl();
		return daoImpl.queryJobInfo();
	}
	
	public static void main(String[] args) {
		ServiceImpl serviceImpl=new ServiceImpl();
		EmployeeInfo emp=new EmployeeInfo(111,"zha111",16,"nan",2,2,2);
		/*List<Employee> list=serviceImpl.queryEmpInfo();
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		/*int flag=serviceImpl.addEmp(emp);
		if(flag==0){
			System.out.println("已存在该员工，添加失败");
		}else{
			System.out.println("添加成功");
		}*/
		/*int i=serviceImpl.updateEmp(emp);
		if(i==0){
			System.out.println("修改失败");
		}else{
			System.out.println("修改成功");
		}*/
	/*	List<Department> list=(List<Department>)serviceImpl.queryDeptInfo();
		for(int i=0;i<list.size();i++)
		{
			Department department=list.get(i);
			System.out.println(department);
		}
		List<Job> list1=(List<Job>)serviceImpl.queryJobInfo();
		for(int i=0;i<list1.size();i++)
		{
			Job job=list1.get(i);
			System.out.println(job);
		}*/
	}

}

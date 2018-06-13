package epms.b_empInfoMana.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import epms.b_empInfoMana.dao.EmpInfoDao;
import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;
import epms.z_util.JdbcUtils;

public class DaoImpl implements EmpInfoDao{

	/**
	 * 查看员工信息
	 */
	@Override
	public List<Employee> queryEmpInfo() {
		QueryRunner rs=new QueryRunner(JdbcUtils.getDataSource());

		String sql="select eid, name,age,sex,dname,jname,time " +
				"from employeeinfo,department,job" +
				" where employeeinfo.deptid=department.id and employeeinfo.jobid=job.id";
		try {
			List<Employee> empList=(List<Employee>)rs.query(sql, new BeanListHandler(Employee.class));
			return empList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加员工信息
	 */
	@Override
	public int addEmp(EmployeeInfo emp) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into employeeinfo values(?,?,?,?,?,?,?)";
		try {
			int i=qr.update(sql, 
					new Object[]{
					   emp.getEid(),emp.getName(),emp.getAge(),
					   emp.getSex(),emp.getDeptId(),emp.getJobId(),
					   emp.getTime()}
			);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 删除员工信息
	 */
	@Override
	public int deleteEmp(EmployeeInfo emp) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="delete from employeeinfo where eid=?";
		try {
			int i=qr.update(sql, emp.getEid());
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 修改员工信息
	 */
	@Override
	public int updateEmp(EmployeeInfo emp) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update employeeinfo set name=?,age=?,sex=?,deptid=?,jobid=?,time=? where eid=?";
		try {
			int i=qr.update(sql, new Object[]{
					   emp.getName(),emp.getAge(),
					   emp.getSex(),emp.getDeptId(),emp.getJobId(),
					   emp.getTime(),emp.getEid()}
			      );
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}
	/**
	 * 增加、删除、修改员工时，判断数据库中是否有该员工
	 * 如果有，则不能进行重复添加操作
	 * 如果没有，则不能进行删除和修改操作
	 */
	@Override
	public boolean judge(EmployeeInfo emp) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select eid from employeeinfo where eid=?";
		try {
			Object[] eid=(Object[])qr.query(sql, new ArrayHandler(), new Object[]{emp.getEid()});
			if(eid!=null){
				return true;//数据库中存在该id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//数据库中不存在该id
	}
	/**
	 * 查询部门表的信息
	 */
	@Override
	public List<Department> queryDeptInfo() {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from department";
		try {
			List<Department> deptList=(List<Department>)qr.query(sql, new BeanListHandler(Department.class));
			return deptList;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询工作表的信息
	 */
	@Override
	public List<Job> queryJobInfo() {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from job";
		try {
			List<Job> jobList=(List<Job>)qr.query(sql, new BeanListHandler(Job.class));
			return jobList;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		DaoImpl daoImpl=new DaoImpl();
		System.out.println(daoImpl.queryEmpInfo().size());
		
	
		
	}

	
	

}

package com.EPMS.empInfoMana.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.Utils.JdbcUtils;
import com.EPMS.empInfoMana.dao.EmployeeDao;
import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;

public class EmployeeDaoImpl implements EmployeeDao{

	//获取部门信息
	@Override
	public List<Department> getDepart() throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from department";
		return qr.query(sql, new BeanListHandler<Department>(Department.class));
	}

	//获取岗位信息
	@Override
	public List<Job> getJob() throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from job";
		return qr.query(sql, new BeanListHandler<Job>(Job.class));
	}

	//获取部门id
	@Override
	public Department getDepartIdByName(String dname) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from department where dname=?";
		Object[] params= {dname};
		return qr.query(sql, new BeanHandler<Department>(Department.class),params);
	}

	//获取岗位id
	@Override
	public Job getJobIdByName(String jname) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from job where jname=?";
		Object[] params= {jname};
		return qr.query(sql, new BeanHandler<Job>(Job.class),params);
	}

	//更新用户信息
	@Override
	public void updateEmployeeInfo(EmployeeInfoVo vo, Department depart, Job job) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update employeeinfo set name=?,age=?,sex=?,department=?,job=?,time=? where eid=?";
		Object[] params= {vo.getEmployeeInfo().getName(),vo.getEmployeeInfo().getAge()
				,vo.getEmployeeInfo().getSex(),depart.getId(),job.getId(),vo.getEmployeeInfo().getTime(),vo.getEmployeeInfo().getEid()};
		qr.update(sql,params);
	}

	

}

package com.EPMS.SalaryMana.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.EPMS.SalaryMana.dao.SalaryDao;
import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;
import com.EPMS.Utils.JdbcUtils;
import com.EPMS.reportMana.po.EmployeeInfo;

public class SalaryDaoImpl implements SalaryDao {

	//查看工资信息
	@Override
	public PersonalSalary findPersonalSalary(Integer eid, Integer year, Integer month) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary where pid=? and year=? and month=?";
		Object[] params= {eid,year,month};
		return qr.query(sql, new BeanHandler<PersonalSalary>(PersonalSalary.class),params);
	}

	//添加工资信息
	@Override
	public void addSalaryInfo(PersonalSalary ps) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into personalsalary(pid,basicsalary,otsalary,allowance,total,year,month) "
				+ "values(?,?,?,?,?,?,?)";
		Object[] params= {ps.getPid(),ps.getBasicsalary(),ps.getOtsalary(),ps.getAllowance(),
				ps.getTotal(),ps.getYear(),ps.getMonth()};
		qr.update(sql,params);
	}

	//获取工资信息
	@Override
	public List<PersonalSalary> getPersonalSalary() throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary";
		return qr.query(sql, new BeanListHandler<PersonalSalary>(PersonalSalary.class));
	}

	@Override
	public EmployeeInfo getEmployeeInfoById(int pid) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from employeeinfo where eid=?";
		Object[] params= {pid};
		return qr.query(sql, new BeanHandler<EmployeeInfo>(EmployeeInfo.class),params);
	}

	//删除工资信息
	@Override
	public void deleteSalary(Integer pid, Integer year, Integer month) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="delete from personalsalary where pid=? and year=? and month=?";
		Object[] params= {pid,year,month};
		qr.update(sql, params);
		
	}

	//查询单个工资信息
	@Override
	public List<PersonalSalary> getOneInfo(Integer pid) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary where pid=?";
		Object[] params= {pid};
		return qr.query(sql, new BeanListHandler<PersonalSalary>(PersonalSalary.class),params);
	}

	//修改工资信息
	@Override
	public void updateSalary(PersonalSalary ps) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update personalsalary set basicsalary=?,otsalary=?,allowance=?,total=? where pid=? and year=? and month=?";
		Object[] params= {ps.getBasicsalary(),ps.getOtsalary(),ps.getAllowance(),ps.getTotal(),ps.getPid(),ps.getYear(),ps.getMonth()};
		qr.update(sql,params);
	}

		

}

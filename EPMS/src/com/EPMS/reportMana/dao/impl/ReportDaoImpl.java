package com.EPMS.reportMana.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.EPMS.Utils.JdbcUtils;
import com.EPMS.reportMana.dao.ReportDao;
import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.Job;
import com.EPMS.reportMana.po.Personalsalary;
import com.EPMS.reportMana.po.Attendance;
import com.EPMS.reportMana.po.Department;


public class ReportDaoImpl implements ReportDao {

	//��ѯְ����Ϣ��
	@Override
	public List<EmployeeInfo> getEmployeeInfo() throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from employeeinfo ";
		List<EmployeeInfo> list= qr.query(sql, new BeanListHandler<EmployeeInfo>(EmployeeInfo.class));
		return list;
	}

	//��ѯ������Ϣ��
	public List<Personalsalary> getSalary() throws Exception{
		//��ѯPersonalsalary��
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary ";
		return qr.query(sql, new BeanListHandler<Personalsalary>(Personalsalary.class));
	}

	//��ѯԱ�����ڱ�
	@Override
	public List<Attendance> getAttend() throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from attendance";
		List<Attendance> list= qr.query(sql, new BeanListHandler<Attendance>(Attendance.class));
		return list;
	}

	//ͨ��id����Ϣ
	@Override
	public EmployeeInfo getEmployeeInfoById(int id) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from employeeinfo where eid=?";
		Object[] params= {id};
		EmployeeInfo info= qr.query(sql, new BeanHandler<EmployeeInfo>(EmployeeInfo.class),params);
		return info;
	}

	//��ѯjob
	@Override
	public Job getJob(int job) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from job where id=?";
		Object[] params= {job};
		Job joblist= qr.query(sql, new BeanHandler<Job>(Job.class),params);
		return joblist;
	}

	@Override
	public Department getDepart(int depart) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from department where id=?";
		Object[] params= {depart};
		return qr.query(sql, new BeanHandler<Department>(Department.class),params);
	}

	//ֻ��һ��Ĺ�����Ϣ
	@Override
	public List<Personalsalary> getSalaryInOneYear(Integer startYear, Integer startMonth, Integer endMonth) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary where year=? and month>=? and month<=?";
		Object[] params= {startYear,startMonth,endMonth};
		return qr.query(sql, new BeanListHandler<Personalsalary>(Personalsalary.class),params);
	}

	//�鿴����Ĺ�����Ϣ
	@Override
	public List<Personalsalary> getSalaryInTwoYear(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql1="select * from personalsalary where year=? and month>=? and month<=?";
		Object[] params1= {startYear,startMonth,12};
		List<Personalsalary> list1=qr.query(sql1, new BeanListHandler<Personalsalary>(Personalsalary.class),params1);
		
		String sql2="select * from personalsalary where year=? and month>=? and month<=?";
		Object[] params2= {endYear,1,endMonth};
		List<Personalsalary> list2=qr.query(sql2, new BeanListHandler<Personalsalary>(Personalsalary.class),params2);
		
		//����
		List<Personalsalary> totalList=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++) {
			totalList.add(list1.get(i));
		}
		for(int i=0;i<list2.size();i++) {
			totalList.add(list2.get(i));
		}
		
		return totalList;
	}

	//��ѯ�������Ϲ�����Ϣ
	@Override
	public List<Personalsalary> getSalaryOverTwoYear(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql1="select * from personalsalary where year=? and month>=? and month<=?";
		Object[] params1= {startYear,startMonth,12};
		List<Personalsalary> list1=qr.query(sql1, new BeanListHandler<Personalsalary>(Personalsalary.class),params1);
		
		String sql2="select * from personalsalary where year=? and month>=? and month<=?";
		Object[] params2= {endYear,1,endMonth};
		List<Personalsalary> list2=qr.query(sql2, new BeanListHandler<Personalsalary>(Personalsalary.class),params2);
		
		String sql3="select * from personalsalary where year>? and year<?";
		Object[] params3= {startYear,endYear};
		List<Personalsalary> list3=qr.query(sql3, new BeanListHandler<Personalsalary>(Personalsalary.class),params3);
		
		//����
		List<Personalsalary> totalList=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++) {
			totalList.add(list1.get(i));
		}
		for(int i=0;i<list2.size();i++) {
			totalList.add(list2.get(i));
		}
		for(int i=0;i<list3.size();i++) {
			totalList.add(list3.get(i));
		}
		
		return totalList;
	}

	//ֻ�鿴һ��Ŀ�����Ϣ
	@Override
	public List<Attendance> getAttendInOneYear(Integer startYear, Integer startMonth, Integer endMonth)
			throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from attendance where year=? and month>=? and month<=?";
		Object[] params= {startYear,startMonth,endMonth};
		return qr.query(sql, new BeanListHandler<Attendance>(Attendance.class),params);
	}
	
	//�鿴����Ŀ�����Ϣ
	@Override
	public List<Attendance> getAttendInTwoYear(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql1="select * from attendance where year=? and month>=? and month<=?";
		Object[] params1= {startYear,startMonth,12};
		List<Attendance> list1=qr.query(sql1, new BeanListHandler<Attendance>(Attendance.class),params1);
		
		String sql2="select * from attendance where year=? and month>=? and month<=?";
		Object[] params2= {endYear,1,endMonth};
		List<Attendance> list2=qr.query(sql2, new BeanListHandler<Attendance>(Attendance.class),params2);
		
		//����
		List<Attendance> totalList=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++) {
			totalList.add(list1.get(i));
		}
		for(int i=0;i<list2.size();i++) {
			totalList.add(list2.get(i));
		}
		
		return totalList;
	}

	//��ѯ�������Ͽ�����Ϣ
	@Override
	public List<Attendance> getAttendOverTwoYear(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql1="select * from attendance where year=? and month>=? and month<=?";
		Object[] params1= {startYear,startMonth,12};
		List<Attendance> list1=qr.query(sql1, new BeanListHandler<Attendance>(Attendance.class),params1);
		
		String sql2="select * from attendance where year=? and month>=? and month<=?";
		Object[] params2= {endYear,1,endMonth};
		List<Attendance> list2=qr.query(sql2, new BeanListHandler<Attendance>(Attendance.class),params2);
		
		String sql3="select * from attendance where year>? and year<?";
		Object[] params3= {startYear,endYear};
		List<Attendance> list3=qr.query(sql3, new BeanListHandler<Attendance>(Attendance.class),params3);
		
		//����
		List<Attendance> totalList=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++) {
			totalList.add(list1.get(i));
		}
		for(int i=0;i<list2.size();i++) {
			totalList.add(list2.get(i));
		}
		for(int i=0;i<list3.size();i++) {
			totalList.add(list3.get(i));
		}
		
		return totalList;
	}

}

package a_personalInfoMana.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.EPMS.Utils.JdbcUtils;

import a_personalInfoMana.dao.PerInfoManaDao;
import a_personalInfoMana.entity.Attendance;
import a_personalInfoMana.entity.Department;
import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.entity.EmployeeInfo;
import a_personalInfoMana.entity.Job;
import a_personalInfoMana.entity.PersonalSalary;
import login.entity.User;

public class DaoImpl implements PerInfoManaDao{

	@Override
	public Employee QueryPerInfo(User user) {
		QueryRunner rs=new QueryRunner(JdbcUtils.getDataSource());

		String sql="select * from employeeinfo where eid=?";
		try {
			EmployeeInfo employeeInfo=(EmployeeInfo)rs.query(sql, new BeanHandler(EmployeeInfo.class),new Object[]{user.getNumber()});
			String sqlDepartment="select dname from department where id=?";	
			Department department=(Department)rs.query(sqlDepartment, new BeanHandler(Department.class), new Object[]{employeeInfo.getDepartment()});
			String sqlJob="select jname from job where id=?";	
			Job job=(Job)rs.query(sqlJob, new BeanHandler(Job.class), new Object[]{employeeInfo.getDepartment()});
			Employee employee =new Employee(employeeInfo.getEid(),employeeInfo.getName(),employeeInfo.getAge(),employeeInfo.getSex(),department.getDname(),job.getJname(),employeeInfo.getTime());
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public Attendance QueryAttendanceInfo(Attendance attendance) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from attendance where eid=? and year=? and month=?";
		try {
			Attendance attendance2=(Attendance)qr.query(sql, new BeanHandler(Attendance.class), new Object[]{attendance.getEid(),attendance.getYear(),attendance.getMonth()});
			return attendance2;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PersonalSalary QuerySalaryInfo(PersonalSalary ps) {

		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from personalsalary where pid=? and year=? and month=?";
		try {
			PersonalSalary personalSalary=(PersonalSalary)qr.query(sql, new BeanHandler(PersonalSalary.class), 
					new Object[]{ps.getPid(),ps.getYear(),ps.getMonth()});
			return personalSalary;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}



	@Override
	public int updatePerPassword(User user) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update user set password=? where number=?";
		try {
			int i=qr.update(sql, new Object[]{user.getPassword(),user.getNumber()});
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}















}

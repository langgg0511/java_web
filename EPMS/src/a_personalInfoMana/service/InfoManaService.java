package a_personalInfoMana.service;

import a_personalInfoMana.entity.Attendance;
import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.entity.PersonalSalary;
import login.entity.User;

public interface InfoManaService {
	/**
	 * 查看个人信息
	 * @param user :登录用户
	 * @return 将查询到的数据封装到Employee中并返回
	 */
	public Employee QueryPerInfo(User user);
	/**
	 * 查看考勤信息
	 * @return 将查询到的数据封装到一个数组中并返回
	 */
	public Attendance QueryAttendanceInfo(Attendance attendance);
	/**
	 * 查看工资信息
	 * @return 将查询到的数据封装到PersonalSalary中并返回
	 */
	public PersonalSalary QuerySalaryInfo(PersonalSalary personalSalary);

	/**
	 * 修改账户密码
	 * @param user:登录用户
	 * @return 修改成功则返回1，否则返回0
	 */
	public int updatePerPassword(User user);
}

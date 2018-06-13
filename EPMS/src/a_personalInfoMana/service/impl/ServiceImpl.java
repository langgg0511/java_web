package a_personalInfoMana.service.impl;

import a_personalInfoMana.dao.impl.DaoImpl;
import a_personalInfoMana.entity.Attendance;
import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.entity.PersonalSalary;
import a_personalInfoMana.service.InfoManaService;
import login.entity.User;

public class ServiceImpl  implements InfoManaService{

	@Override
	public Employee QueryPerInfo(User user) {
		DaoImpl daoImpl=new DaoImpl();
		return daoImpl.QueryPerInfo(user);
	}

	@Override
	public Attendance QueryAttendanceInfo(Attendance attendance) {
		DaoImpl daoImpl=new DaoImpl();
		return daoImpl.QueryAttendanceInfo(attendance);
	}

	@Override
	public PersonalSalary QuerySalaryInfo(PersonalSalary personalSalary) {
		DaoImpl daoImpl=new DaoImpl();
		return daoImpl.QuerySalaryInfo(personalSalary);
	}

	@Override
	public int updatePerPassword(User user) {
		DaoImpl daoImpl=new DaoImpl();
		return daoImpl.updatePerPassword(user);
	}
	public static void main(String[] args) {
		ServiceImpl serviceImpl =new ServiceImpl();
		System.out.println(serviceImpl.QueryPerInfo(new User("1","21")));
		
	}



}

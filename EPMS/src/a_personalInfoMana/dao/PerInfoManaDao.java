package a_personalInfoMana.dao;

import a_personalInfoMana.entity.Attendance;
import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.entity.PersonalSalary;
import login.entity.User;

public interface PerInfoManaDao {
	/**
	 * �鿴������Ϣ
	 * @param user :��¼�û�
	 * @return ����ѯ�������ݷ�װ��Employee�в�����
	 */
	public Employee QueryPerInfo(User user);
	/**
	 * �鿴������Ϣ
	 * @return ����ѯ�������ݷ�װ��һ�������в�����
	 */
	public Attendance QueryAttendanceInfo(Attendance attendance);
	/**
	 * �鿴������Ϣ
	 * @return ����ѯ�������ݷ�װ��PersonalSalary�в�����
	 */
	public PersonalSalary QuerySalaryInfo(PersonalSalary personalSalary);

	/**
	 * �޸��˻�����
	 * @param user:��¼�û�
	 * @return �޸ĳɹ��򷵻�1�����򷵻�0
	 */
	public int updatePerPassword(User user);
}

package c_attanInfoMana.dao;

import java.util.List;
import c_attanInfoMana.entity.Attendance;

public interface AttenInfoDao {
	/**
	 * ����eid��Ա���ţ���year����ݣ���month���·ݣ���ѯԱ��������Ϣ
	 */
	public List<Attendance> queryAttanInfo(Attendance attendance);
	/**
	 * �޸�Ա���ĳ�����Ϣ
	 */
	public int updateAttanInfo(Attendance attendance);
	/**
	 * ��ѯԱ��������Ϣʱ���ж����ݿ����Ƿ��и�Ա��
	 */
	public boolean judge(Attendance	 attendance); 
}

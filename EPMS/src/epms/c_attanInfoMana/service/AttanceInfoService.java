package epms.c_attanInfoMana.service;

import java.util.List;

import epms.c_attanInfoMana.entity.Attendance;

public interface AttanceInfoService {
	/**
	 * ����eid��Ա���ţ���year����ݣ���month���·ݣ���ѯԱ��������Ϣ
	 */
	public List<Attendance> queryAttanInfo(Attendance attendance);
	/**
	 * �޸�Ա���ĳ�����Ϣ
	 */
	public int updateAttanInfo(Attendance attendance);
}

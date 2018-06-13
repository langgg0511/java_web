package epms.c_attanInfoMana.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import epms.c_attanInfoMana.entity.Attendance;
import epms.z_util.JdbcUtils;

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

package epms.c_attanInfoMana.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import epms.c_attanInfoMana.entity.Attendance;
import epms.z_util.JdbcUtils;

public interface AttenInfoDao {
	/**
	 * 根据eid（员工号）、year（年份）、month（月份）查询员工出勤信息
	 */
	public List<Attendance> queryAttanInfo(Attendance attendance);
	/**
	 * 修改员工的出勤信息
	 */
	public int updateAttanInfo(Attendance attendance);
	/**
	 * 查询员工出勤信息时，判断数据库中是否有该员工
	 */
	public boolean judge(Attendance	 attendance); 
}

package c_attanInfoMana.dao;

import java.util.List;
import c_attanInfoMana.entity.Attendance;

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

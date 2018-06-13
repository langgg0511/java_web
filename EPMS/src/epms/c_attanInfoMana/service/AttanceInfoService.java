package epms.c_attanInfoMana.service;

import java.util.List;

import epms.c_attanInfoMana.entity.Attendance;

public interface AttanceInfoService {
	/**
	 * 根据eid（员工号）、year（年份）、month（月份）查询员工出勤信息
	 */
	public List<Attendance> queryAttanInfo(Attendance attendance);
	/**
	 * 修改员工的出勤信息
	 */
	public int updateAttanInfo(Attendance attendance);
}

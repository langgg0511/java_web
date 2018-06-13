package c_attanInfoMana.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.EPMS.Utils.JdbcUtils;

import c_attanInfoMana.dao.AttenInfoDao;
import c_attanInfoMana.entity.Attendance;

public class DaoImpl implements AttenInfoDao{
	/**
	 * 根据eid（员工号）、year（年份）、month（月份）查询员工出勤信息
	 */
	@Override
	public List<Attendance> queryAttanInfo(Attendance attendance) {
		QueryRunner  qr=new QueryRunner(com.EPMS.Utils.JdbcUtils.getDataSource());
		String sql="select * from attendance where eid=? and month=? and year=?";
		
		try {
			List<Attendance> list=(List<Attendance>)qr.query(sql, new BeanListHandler(Attendance.class)
									,new Object[]{attendance.getEid(),attendance.getMonth(),attendance.getYear()});
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改员工的出勤信息
	 */
	@Override
	public int updateAttanInfo(Attendance attendance) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update attendance set absenteeism=?,_leave=?,prin_day=?,overtime=?,onduty_day=? " +
				   "where eid=? and year=? and month=?";
		try {
			int i=qr.update(sql, 
					        new Object[]{attendance.getAbsenteeism(),attendance.get_Leave(),
							attendance.getPrin_day(),attendance.getOnduty_day(),
							attendance.getOnduty_day(),attendance.getEid(),
							attendance.getYear(),attendance.getMonth()});
			return i;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 增加、删除、修改员工时，判断数据库中是否有该员工
	 * 如果有，则不能进行重复添加操作
	 * 如果没有，则不能进行删除和修改操作
	 */
	@Override
	public boolean judge(Attendance	 attendance) {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select eid from attendance where eid=? and year=? and month=?";
		try {
			Object[] eid=(Object[])qr.query(sql, new ArrayHandler(), new Object[]{attendance.getEid(),attendance.getYear(),attendance.getMonth()});
			if(eid!=null){
				return true;//数据库中存在该id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//数据库中不存在该id
	}
	public static void main(String[] args) {
		Attendance attendance=new Attendance(14, 2017, 3, 2, 12, 12, 12, 12);
		
		attendance.setEid(1);
		attendance.setYear(2017);
		attendance.setMonth(3);
		DaoImpl daoImpl=new DaoImpl();
		List list=daoImpl.queryAttanInfo(attendance);
		for(int i=0;i<list.size();i++){
			Attendance a=(Attendance)list.get(i);
			System.out.println(a);
		}
		
		//System.out.println(daoImpl.judge(attendance));
	}

}

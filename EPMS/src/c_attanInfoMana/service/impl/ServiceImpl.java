package c_attanInfoMana.service.impl;

import java.util.List;

import c_attanInfoMana.dao.impl.DaoImpl;
import c_attanInfoMana.entity.Attendance;
import c_attanInfoMana.service.AttanceInfoService;

public class ServiceImpl implements AttanceInfoService{

	@Override
	public List<Attendance> queryAttanInfo(Attendance attendance) {
		//判断数据库中是否存在该员工某年某月的考勤信息，
		//有则返回true，否则返回false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(attendance);
		if(flag){
			List<Attendance> list=daoImpl.queryAttanInfo(attendance);
			return list;
		}else{
			return null;
		}
		
	}

	@Override
	public int updateAttanInfo(Attendance attendance) {
		//判断数据库中是否存在该员工某年某月的考勤信息，
		//有则返回true，否则返回false		
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(attendance);
		if(flag){
			int i=daoImpl.updateAttanInfo(attendance);
			return i;//修改成功则返回1，修改失败返回0
		}else{
			return 0;//不存在该员工，修改失败，返回0
		}
		
	}
}

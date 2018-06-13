package epms.c_attanInfoMana.service.impl;

import java.util.List;

import epms.c_attanInfoMana.dao.impl.DaoImpl;
import epms.c_attanInfoMana.entity.Attendance;
import epms.c_attanInfoMana.service.AttanceInfoService;

public class ServiceImpl implements AttanceInfoService{

	@Override
	public List<Attendance> queryAttanInfo(Attendance attendance) {
		//�ж����ݿ����Ƿ���ڸ�Ա��ĳ��ĳ�µĿ�����Ϣ��
		//���򷵻�true�����򷵻�false
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
		//�ж����ݿ����Ƿ���ڸ�Ա��ĳ��ĳ�µĿ�����Ϣ��
		//���򷵻�true�����򷵻�false		
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(attendance);
		if(flag){
			int i=daoImpl.updateAttanInfo(attendance);
			return i;//�޸ĳɹ��򷵻�1���޸�ʧ�ܷ���0
		}else{
			return 0;//�����ڸ�Ա�����޸�ʧ�ܣ�����0
		}
		
	}
/*public static void main(String[] args) {
	Attendance attendance=new Attendance(1, 2017, 12, 2, 12, 12, 12, 12);
	ServiceImpl serviceImpl=new ServiceImpl();
	//System.out.println(serviceImpl.queryAttanInfo(attendance).get(0));
	System.out.println(serviceImpl.updateAttanInfo(attendance));
}*/
}

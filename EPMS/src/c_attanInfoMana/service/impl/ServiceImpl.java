package c_attanInfoMana.service.impl;

import java.util.List;

import c_attanInfoMana.dao.impl.DaoImpl;
import c_attanInfoMana.entity.Attendance;
import c_attanInfoMana.service.AttanceInfoService;

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
}

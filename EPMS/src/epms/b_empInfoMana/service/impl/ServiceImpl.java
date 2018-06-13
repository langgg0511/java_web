package epms.b_empInfoMana.service.impl;

import java.util.List;

import epms.b_empInfoMana.dao.impl.DaoImpl;
import epms.b_empInfoMana.entity.Department;
import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.entity.Job;
import epms.b_empInfoMana.service.EmpInfoService;

public class ServiceImpl implements EmpInfoService{
	/**
	 * �鿴Ա����Ϣ
	 */
	@Override
	public List<Employee> queryEmpInfo() {
		DaoImpl daoImpl=new DaoImpl();		
		return daoImpl.queryEmpInfo();
	}
	/**
	 * ����Ա����Ϣ
	 */
	@Override
	public int addEmp(EmployeeInfo emp) {
		//1.�ж����ݿ����Ƿ��Ѿ����ڸ�Ա��,�����򷵻�true���������򷵻�false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//���flagΪtrue�������ݿ��д��ڸ�Ա���������Խ�����Ӳ���
			return 0;
		}else{//���flagΪfalse�������ݿ��в����ڸ�Ա�������Խ�����Ӳ���
			return(daoImpl.addEmp(emp));//��ӳɹ��򷵻�1�����򷵻�0
		}

	}
	/**
	 * ɾ��Ա����Ϣ
	 */
	@Override
	public int deleteEmp(EmployeeInfo emp) {
		//1.�ж����ݿ����Ƿ��Ѿ����ڸ�Ա��,�����򷵻�true���������򷵻�false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//���flagΪtrue�������ݿ��д��ڸ�Ա�������Խ���ɾ������
			return (daoImpl.deleteEmp(emp));//ɾ���ɹ��򷵻�1�����򷵻�0
		}else{//���flagΪfalse�������ݿ��в����ڸ�Ա�����޷�����ɾ������
			return 0;
		}
	}
	/**
	 * �޸�Ա����Ϣ
	 */
	@Override
	public int updateEmp(EmployeeInfo emp) {
		//1.�ж����ݿ����Ƿ��Ѿ����ڸ�Ա��,�����򷵻�true���������򷵻�false
		DaoImpl daoImpl=new DaoImpl();
		boolean flag=daoImpl.judge(emp);
		if (flag) {//���flagΪtrue�������ݿ��д��ڸ�Ա�������Խ����޸Ĳ���
			return (daoImpl.updateEmp(emp));//�޸ĳɹ��򷵻�1�����򷵻�0
		}else{//���flagΪfalse�������ݿ��в����ڸ�Ա�����޷������޸Ĳ���
			return 0;
		}
	}
	/**
	 * ��ѯ���ű����Ϣ
	 */
	@Override
	public List<Department> queryDeptInfo() {
		DaoImpl daoImpl = new DaoImpl();
		return daoImpl.queryDeptInfo();
	}
	/**
	 * ��ѯ���������Ϣ
	 */
	@Override
	public List<Job> queryJobInfo() {
		DaoImpl daoImpl = new DaoImpl();
		return daoImpl.queryJobInfo();
	}
	
	public static void main(String[] args) {
		ServiceImpl serviceImpl=new ServiceImpl();
		EmployeeInfo emp=new EmployeeInfo(111,"zha111",16,"nan",2,2,2);
		/*List<Employee> list=serviceImpl.queryEmpInfo();
		for (Employee employee : list) {
			System.out.println(employee);
		}*/
		/*int flag=serviceImpl.addEmp(emp);
		if(flag==0){
			System.out.println("�Ѵ��ڸ�Ա�������ʧ��");
		}else{
			System.out.println("��ӳɹ�");
		}*/
		/*int i=serviceImpl.updateEmp(emp);
		if(i==0){
			System.out.println("�޸�ʧ��");
		}else{
			System.out.println("�޸ĳɹ�");
		}*/
	/*	List<Department> list=(List<Department>)serviceImpl.queryDeptInfo();
		for(int i=0;i<list.size();i++)
		{
			Department department=list.get(i);
			System.out.println(department);
		}
		List<Job> list1=(List<Job>)serviceImpl.queryJobInfo();
		for(int i=0;i<list1.size();i++)
		{
			Job job=list1.get(i);
			System.out.println(job);
		}*/
	}

}

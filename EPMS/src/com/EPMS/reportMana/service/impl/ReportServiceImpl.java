package com.EPMS.reportMana.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.EPMS.reportMana.dao.ReportDao;
import com.EPMS.reportMana.dao.impl.ReportDaoImpl;
import com.EPMS.reportMana.po.Attendance;
import com.EPMS.reportMana.po.AttendanceVo;
import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;
import com.EPMS.reportMana.po.Personalsalary;
import com.EPMS.reportMana.po.PersonalsalaryVo;
import com.EPMS.reportMana.service.ReportService;

public class ReportServiceImpl implements ReportService{

	private ReportDao dao=new ReportDaoImpl();
	
	@Override
	public List<EmployeeInfoVo> getEmployeeInfo() throws Exception {
		
		List<EmployeeInfo> Infolist=dao.getEmployeeInfo();
		//�����װ��EmployeeInfoVo
		List<EmployeeInfoVo> Volist=new ArrayList<>();
		
		for(int i=0;i<Infolist.size();i++) {
			EmployeeInfoVo vo=new EmployeeInfoVo();
			EmployeeInfo employee=Infolist.get(i);
			int job=employee.getJob();
			int depart=employee.getDepartment();
			//ͨ��jobֵ��ѯjob��
			Job Joblist=dao.getJob(job);
			//ͨ��depart��ѯdepartment��
			Department departList=dao.getDepart(depart);
			vo.setEmployeeInfo(employee);
			vo.setJob(Joblist);
			vo.setDepartment(departList);
			
			Volist.add(vo);
		}
		
		return Volist;
	}
	
	//���ҹ��ʱ�
	@Override
	public List<PersonalsalaryVo> getSalary() throws Exception {
		List<Personalsalary> ps=dao.getSalary();
		//�����װ��PersonalsalaryVo
		List<PersonalsalaryVo> volist=new ArrayList<>();
		
		for(int i=0;i<ps.size();i++) {
			int pid=ps.get(i).getPid();
			//ͨ��id��ѯԱ����Ϣ��
			EmployeeInfo info=dao.getEmployeeInfoById(pid);
			PersonalsalaryVo psVo=new PersonalsalaryVo();
			psVo.setName(info.getName());
			psVo.setPs(ps.get(i));
			volist.add(psVo);
		}
		return volist;
	}

	@Override
	public List<AttendanceVo> getAttend() throws Exception {
		List<Attendance> list1=dao.getAttend();
		
		//����һ��list���ڴ洢Attendance����
		List<AttendanceVo> list2=new ArrayList<>();
		
		for(Attendance attList:list1) {
			AttendanceVo attVo=new AttendanceVo();
			//��ȡid
			int id=attList.getEid();
			//��ѯ��Ϣ
			EmployeeInfo list3=dao.getEmployeeInfoById(id);
			attVo.setAttendance(attList);
			//����name����
			attVo.setName(list3.getName());
			list2.add(attVo);
			
		}
		return list2;
	}

	//������Ϣ�����·ݲ�ѯ
	@Override
	public List<PersonalsalaryVo> getSalaryInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		Integer year=endYear-startYear;
		//ֻ����һ���
		if(year==0) {
			List<Personalsalary> ps=dao.getSalaryInOneYear(startYear,startMonth,endMonth);
			//�����װ��PersonalsalaryVo
			List<PersonalsalaryVo> volist=new ArrayList<>();
			
			for(int i=0;i<ps.size();i++) {
				int pid=ps.get(i).getPid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(pid);
				PersonalsalaryVo psVo=new PersonalsalaryVo();
				psVo.setName(info.getName());
				psVo.setPs(ps.get(i));
				volist.add(psVo);
			}
			return volist;
		}
		//��ѯ����֮�ڵ�
		else if(year==1) {
			List<Personalsalary> ps=dao.getSalaryInTwoYear(startYear,startMonth,endYear,endMonth);
			//�����װ��PersonalsalaryVo
			List<PersonalsalaryVo> volist=new ArrayList<>();
			
			for(int i=0;i<ps.size();i++) {
				int pid=ps.get(i).getPid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(pid);
				PersonalsalaryVo psVo=new PersonalsalaryVo();
				psVo.setName(info.getName());
				psVo.setPs(ps.get(i));
				volist.add(psVo);
			}
			return volist;
		}
		//��ѯ�������ϵ�
		else if(year>1) {
			List<Personalsalary> ps=dao.getSalaryOverTwoYear(startYear,startMonth,endYear,endMonth);
			//�����װ��PersonalsalaryVo
			List<PersonalsalaryVo> volist=new ArrayList<>();
			
			for(int i=0;i<ps.size();i++) {
				int pid=ps.get(i).getPid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(pid);
				PersonalsalaryVo psVo=new PersonalsalaryVo();
				psVo.setName(info.getName());
				psVo.setPs(ps.get(i));
				volist.add(psVo);
			}
			return volist;
		}
		return null;
		
	}

	//���ڱ����·ݲ�ѯ
	@Override
	public List<AttendanceVo> getAttendInfoByMonth(Integer startYear, Integer startMonth, Integer endYear,
			Integer endMonth) throws Exception {
		Integer year=endYear-startYear;
		//ֻ����һ���
		if(year==0) {
			List<Attendance> att=dao.getAttendInOneYear(startYear,startMonth,endMonth);
			//�����װ��PersonalsalaryVo
			List<AttendanceVo> volist=new ArrayList<>();
			
			for(int i=0;i<att.size();i++) {
				int eid=att.get(i).getEid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(eid);
				AttendanceVo attVo=new AttendanceVo();
				attVo.setName(info.getName());
				attVo.setAttendance(att.get(i));
				volist.add(attVo);
			}
			return volist;
		}
		//��ѯ����֮�ڵ�
		else if(year==1) {
			List<Attendance> att=dao.getAttendInTwoYear(startYear,startMonth,endYear,endMonth);
			//�����װ��PersonalsalaryVo
			List<AttendanceVo> volist=new ArrayList<>();
			
			for(int i=0;i<att.size();i++) {
				int eid=att.get(i).getEid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(eid);
				AttendanceVo attVo=new AttendanceVo();
				attVo.setName(info.getName());
				attVo.setAttendance(att.get(i));
				volist.add(attVo);
			}
			return volist;
		}
		//��ѯ�������ϵ�
		else if(year>1) {
			List<Attendance> att=dao.getAttendOverTwoYear(startYear,startMonth,endYear,endMonth);
			//�����װ��PersonalsalaryVo
			List<AttendanceVo> volist=new ArrayList<>();
			
			for(int i=0;i<att.size();i++) {
				int eid=att.get(i).getEid();
				//ͨ��id��ѯԱ����Ϣ��
				EmployeeInfo info=dao.getEmployeeInfoById(eid);
				AttendanceVo attVo=new AttendanceVo();
				attVo.setName(info.getName());
				attVo.setAttendance(att.get(i));
				volist.add(attVo);
			}
			return volist;
		}
		return null;
	}

}

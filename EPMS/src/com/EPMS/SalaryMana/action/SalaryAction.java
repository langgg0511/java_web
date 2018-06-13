package com.EPMS.SalaryMana.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EPMS.SalaryMana.po.PersonalSalary;
import com.EPMS.SalaryMana.po.PersonalSalaryVo;
import com.EPMS.SalaryMana.service.SalaryService;
import com.EPMS.SalaryMana.service.impl.SalaryServiceImpl;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.service.ReportService;
import com.EPMS.reportMana.service.impl.ReportServiceImpl;


public class SalaryAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SalaryService salaryService=new SalaryServiceImpl();
	private ReportService reportService=new ReportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String methodName=request.getParameter("method");
		//��ȡ�������
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡeid
	public void getEid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("list", employeeInfo);
		request.getRequestDispatcher("/jsp/add_salary.jsp").forward(request, response);
	}
	
	//��ӹ�����Ϣ
	public void addSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		String time=request.getParameter("time");
		//��ȡ���
		Integer year=Integer.parseInt(time.substring(0, 4));
		//��ȡ�·�
		Integer month=Integer.parseInt(time.substring(5, 7));
		//��������
		Integer basicsalary=Integer.parseInt(request.getParameter("basicsalary"));
		//����
		Integer allowance=Integer.parseInt(request.getParameter("allowance"));
		//�Ӱ��
		Integer otsalary=Integer.parseInt(request.getParameter("otsalary"));
		
		PersonalSalary ps=new PersonalSalary();
		ps.setPid(eid);
		ps.setBasicsalary(basicsalary);
		ps.setAllowance(allowance);
		ps.setOtsalary(otsalary);
		ps.setYear(year);
		ps.setMonth(month);
		ps.setTotal(basicsalary+allowance+otsalary);
		//�ж������·��Ƿ����
		boolean flag=salaryService.isInfoExist(eid,year,month);
		if(flag==true) {
			salaryService.addSalaryInfo(ps);
		}else {
			request.setAttribute("message", "���¹�����Ϣ�Ѵ���");
			request.getRequestDispatcher("/SalaryMana?method=getEid").forward(request, response);
			
		}
	}
	
	//��ȡԱ��id�����й�����Ϣ
	public void getDeleteInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//��ȡԱ��������Ϣ
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/delete_salary.jsp").forward(request, response);
	}
	
	//ɾ��������Ϣ
	public void deleteSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Integer year=Integer.parseInt(request.getParameter("year"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		salaryService.deleteSalary(pid,year,month);
		request.getRequestDispatcher("/SalaryMana?method=getDeleteInfo").forward(request, response);
	}
	
	
	//��ȡ����������Ϣ
	public void getOneInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/delete_salary.jsp").forward(request, response);
	}
	
	//��ȡ����������Ϣ
	public void getOneInfoBySearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/search_salary.jsp").forward(request, response);
	}
	
	//��ȡԱ��id�����й�����Ϣ
	public void getSearchInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//��ȡԱ��������Ϣ
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/search_salary.jsp").forward(request, response);
	}
	
	//��ȡԱ��id�����й�����Ϣ
	public void getUpdateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//��ȡԱ��������Ϣ
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/update_salary.jsp").forward(request, response);
	}
	
	//��ȡ����������Ϣ
	public void getOneInfoByUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//��ȡԱ��id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/update_salary.jsp").forward(request, response);
	}
	
	//���½���
	public void toUpdateSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Integer year=Integer.parseInt(request.getParameter("year"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		
		request.setAttribute("pid", pid);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.getRequestDispatcher("/jsp/update_salary_info.jsp").forward(request, response);
	}
	
	//�޸Ĺ�����Ϣ
	public void updateSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Integer year=Integer.parseInt(request.getParameter("year"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		
		Integer basicsalary=Integer.parseInt(request.getParameter("basicsalary"));
		Integer allowance=Integer.parseInt(request.getParameter("allowance"));
		Integer otsalary=Integer.parseInt(request.getParameter("otsalary"));
		
		PersonalSalary ps=new PersonalSalary();
		ps.setPid(pid);
		ps.setBasicsalary(basicsalary);
		ps.setAllowance(allowance);
		ps.setOtsalary(otsalary);
		ps.setYear(year);
		ps.setMonth(month);
		ps.setTotal(basicsalary+allowance+otsalary);
		
		salaryService.updateSalary(ps);
		request.getRequestDispatcher("/SalaryMana?method=getUpdateInfo").forward(request, response);
	}
	
	
}

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
		//获取方法
		String methodName=request.getParameter("method");
		//获取反射机制
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取eid
	public void getEid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("list", employeeInfo);
		request.getRequestDispatcher("/jsp/add_salary.jsp").forward(request, response);
	}
	
	//添加工资信息
	public void addSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		String time=request.getParameter("time");
		//截取年份
		Integer year=Integer.parseInt(time.substring(0, 4));
		//截取月份
		Integer month=Integer.parseInt(time.substring(5, 7));
		//基本工资
		Integer basicsalary=Integer.parseInt(request.getParameter("basicsalary"));
		//津贴
		Integer allowance=Integer.parseInt(request.getParameter("allowance"));
		//加班费
		Integer otsalary=Integer.parseInt(request.getParameter("otsalary"));
		
		PersonalSalary ps=new PersonalSalary();
		ps.setPid(eid);
		ps.setBasicsalary(basicsalary);
		ps.setAllowance(allowance);
		ps.setOtsalary(otsalary);
		ps.setYear(year);
		ps.setMonth(month);
		ps.setTotal(basicsalary+allowance+otsalary);
		//判断输入月份是否存在
		boolean flag=salaryService.isInfoExist(eid,year,month);
		if(flag==true) {
			salaryService.addSalaryInfo(ps);
		}else {
			request.setAttribute("message", "该月工资信息已存在");
			request.getRequestDispatcher("/SalaryMana?method=getEid").forward(request, response);
			
		}
	}
	
	//获取员工id和所有工资信息
	public void getDeleteInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//获取员工工资信息
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/delete_salary.jsp").forward(request, response);
	}
	
	//删除工资信息
	public void deleteSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Integer year=Integer.parseInt(request.getParameter("year"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		salaryService.deleteSalary(pid,year,month);
		request.getRequestDispatcher("/SalaryMana?method=getDeleteInfo").forward(request, response);
	}
	
	
	//获取单个工资信息
	public void getOneInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/delete_salary.jsp").forward(request, response);
	}
	
	//获取单个工资信息
	public void getOneInfoBySearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/search_salary.jsp").forward(request, response);
	}
	
	//获取员工id和所有工资信息
	public void getSearchInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//获取员工工资信息
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/search_salary.jsp").forward(request, response);
	}
	
	//获取员工id和所有工资信息
	public void getUpdateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		//获取员工工资信息
		List<PersonalSalaryVo> vo=salaryService.getPersonalSalaryVo();
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/update_salary.jsp").forward(request, response);
	}
	
	//获取单个工资信息
	public void getOneInfoByUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("eid"));
		//获取员工id
		List<EmployeeInfoVo> employeeInfo=reportService.getEmployeeInfo();
		request.setAttribute("eid", employeeInfo);
		List<PersonalSalaryVo> vo=salaryService.getOneInfo(pid);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/jsp/update_salary.jsp").forward(request, response);
	}
	
	//更新界面
	public void toUpdateSalary(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer pid=Integer.parseInt(request.getParameter("pid"));
		Integer year=Integer.parseInt(request.getParameter("year"));
		Integer month=Integer.parseInt(request.getParameter("month"));
		
		request.setAttribute("pid", pid);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.getRequestDispatcher("/jsp/update_salary_info.jsp").forward(request, response);
	}
	
	//修改工资信息
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

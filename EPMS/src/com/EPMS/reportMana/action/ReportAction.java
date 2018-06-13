package com.EPMS.reportMana.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EPMS.reportMana.po.AttendanceVo;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.PersonalsalaryVo;
import com.EPMS.reportMana.service.ReportService;
import com.EPMS.reportMana.service.impl.ReportServiceImpl;

public class ReportAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ReportService service=new ReportServiceImpl();
	
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
	
	//人力资源报表
	public void getEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EmployeeInfoVo> list=service.getEmployeeInfo();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/hr_table.jsp").forward(request, response);
	}
	
	//工资报表
	public void getSalaryInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PersonalsalaryVo> list=(List<PersonalsalaryVo>) service.getSalary();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/salary_table.jsp").forward(request, response);
	}
	
	//工资信息报表月份查询
	public void getSalaryInfoByMonth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		Integer startYear=Integer.parseInt(startDate.substring(0, 4));
		Integer startMonth=Integer.parseInt(startDate.substring(5, 7));
		Integer endYear=Integer.parseInt(endDate.substring(0, 4));
		Integer endMonth=Integer.parseInt(endDate.substring(5, 7));
		List<PersonalsalaryVo> list=service.getSalaryInfoByMonth(startYear,startMonth,endYear,endMonth);
		/*if(list==null) {
			request.setAttribute("mess", "日期选择有误");
			request.getRequestDispatcher("/reportMana?method=getSalaryInfo").forward(request, response);
		}else {*/
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/salary_table.jsp").forward(request, response);
		
		
	}
	
	//员工考勤报表
	public void getAttendInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<AttendanceVo> list=(List<AttendanceVo>) service.getAttend();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/attendance_table.jsp").forward(request, response);
	}	
	
	//工资信息报表月份查询
	public void getAttendInfoByMonth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		Integer startYear=Integer.parseInt(startDate.substring(0, 4));
		Integer startMonth=Integer.parseInt(startDate.substring(5, 7));
		Integer endYear=Integer.parseInt(endDate.substring(0, 4));
		Integer endMonth=Integer.parseInt(endDate.substring(5, 7));
		List<AttendanceVo> list=service.getAttendInfoByMonth(startYear,startMonth,endYear,endMonth);
		/*if(list==null) {
			request.setAttribute("mess", "日期选择有误");
			request.getRequestDispatcher("/reportMana?method=getSalaryInfo").forward(request, response);
		}else {*/
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/attendance_table.jsp").forward(request, response);
		
		
	}

}

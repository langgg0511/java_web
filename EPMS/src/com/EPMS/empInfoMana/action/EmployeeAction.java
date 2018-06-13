package com.EPMS.empInfoMana.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EPMS.empInfoMana.service.EmployeeService;
import com.EPMS.empInfoMana.service.impl.EmployeeServiceImpl;
import com.EPMS.reportMana.po.Department;
import com.EPMS.reportMana.po.EmployeeInfo;
import com.EPMS.reportMana.po.EmployeeInfoVo;
import com.EPMS.reportMana.po.Job;
import com.EPMS.reportMana.service.ReportService;
import com.EPMS.reportMana.service.impl.ReportServiceImpl;

public class EmployeeAction extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ReportService reportService=new ReportServiceImpl();
	private EmployeeService emplService=new EmployeeServiceImpl();
	
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
	
	//人事信息查看
	public void getEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EmployeeInfoVo> list=reportService.getEmployeeInfo();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/empInfoList.jsp").forward(request, response);
	}
	
	//人事信息查看更新
	public void getEmployeeInfoInUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EmployeeInfoVo> list=reportService.getEmployeeInfo();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/empInfoListInUpdate.jsp").forward(request, response);
	}
	
	//跳转到人事信息更新
	public void toEmployeeInfoInUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Integer age=Integer.parseInt(request.getParameter("age"));
		String sex=request.getParameter("sex");
		Integer did=Integer.parseInt(request.getParameter("department"));
		Integer jid=Integer.parseInt(request.getParameter("job"));
		Integer time=Integer.parseInt(request.getParameter("time"));
		
		Department depart=new Department();
		depart.setId(did);
		Job job=new Job();
		job.setId(jid);
		
		EmployeeInfo emplInfo=new EmployeeInfo();
		emplInfo.setEid(id);
		emplInfo.setName(name);
		emplInfo.setAge(age);
		emplInfo.setSex(sex);
		emplInfo.setTime(time);
		
		EmployeeInfoVo vo=new EmployeeInfoVo();
		vo.setDepartment(depart);
		vo.setJob(job);
		vo.setEmployeeInfo(emplInfo);
		
		List<Department> departList=emplService.getDepart();
		List<Job> jobList=emplService.getJob();
		
		request.setAttribute("vo", vo);
		request.setAttribute("departList", departList);
		request.setAttribute("jobList", jobList);
		request.getRequestDispatcher("/jsp/EmpInfoUpdate.jsp").forward(request, response);
	}
	
	//更新
	public void updateEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		String name=request.getParameter("name");
		Integer age=Integer.parseInt(request.getParameter("age"));
		String sex=request.getParameter("sex");
		String dname=request.getParameter("dname");
		String jname=request.getParameter("jname");
		Integer time=Integer.parseInt(request.getParameter("time"));
		
		Department depart=new Department();
		depart.setDname(dname);;
		Job job=new Job();
		job.setJname(jname);
		
		EmployeeInfo emplInfo=new EmployeeInfo();
		emplInfo.setEid(eid);
		emplInfo.setName(name);
		emplInfo.setAge(age);
		emplInfo.setSex(sex);
		emplInfo.setTime(time);
		
		EmployeeInfoVo vo=new EmployeeInfoVo();
		vo.setDepartment(depart);
		vo.setJob(job);
		vo.setEmployeeInfo(emplInfo);
		
		//更新用户信息
		emplService.updateEmployeeInfo(vo);
		request.getRequestDispatcher("/empInfoMana?method=getEmployeeInfo").forward(request, response);
	}
	
}

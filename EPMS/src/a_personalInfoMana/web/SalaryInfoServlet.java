package a_personalInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.entity.PersonalSalary;
import a_personalInfoMana.service.impl.ServiceImpl;
import login.entity.User;


public class SalaryInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext=request.getServletContext();
		
		//获取要查询的月份
		int number=new Integer((String)servletContext.getAttribute("number"));
		int year=new Integer(request.getParameter("year"));
		int month=new Integer(request.getParameter("month"));
		
		PersonalSalary personalSalary=new PersonalSalary();
		personalSalary.setPid(number);
		personalSalary.setYear(year);
		personalSalary.setMonth(month);
		
		
		User user=new User();
		user.setNumber((String)servletContext.getAttribute("number"));
		//获取员工在某月的工资信息
		ServiceImpl serviceImpl=new ServiceImpl();
		PersonalSalary ps=serviceImpl.QuerySalaryInfo(personalSalary);
		Employee emp=serviceImpl.QueryPerInfo(user);
		
		
		//把工资信息存储到域对象中
		servletContext.setAttribute("ps", ps);
		servletContext.setAttribute("emp", emp);
		response.sendRedirect(request.getContextPath()+"/jsp/info_salary.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

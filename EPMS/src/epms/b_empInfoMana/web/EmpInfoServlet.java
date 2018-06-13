package epms.b_empInfoMana.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epms.b_empInfoMana.entity.Employee;
import epms.b_empInfoMana.service.impl.ServiceImpl;

/**
 * 获取数据库中的员工信息表
 * @author guo7jun
 *
 */
public class EmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		
		//获取员工信息
		ServiceImpl serviceImpl=new ServiceImpl();
		List<Employee> list=(List<Employee>)serviceImpl.queryEmpInfo();
	
		
		//把获取到的员工信息存储到域对象中
		context.setAttribute("list", list);
		//重定向到EmpInfoList.jsp中
		response.sendRedirect("/epms/EmpInfoList.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

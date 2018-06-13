package a_personalInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_personalInfoMana.entity.Employee;
import a_personalInfoMana.service.impl.ServiceImpl;
import login.entity.User;



/**
 * 查看个人信息 
 */
public class PerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number=request.getParameter("number");
		User user=new User();
		user.setNumber(number);
		ServiceImpl serviceImpl=new ServiceImpl();
		Employee employee=serviceImpl.QueryPerInfo(user);
		ServletContext servletContext=request.getServletContext();
		servletContext.setAttribute("employee", employee);
		response.sendRedirect(request.getContextPath()+"/jsp/info.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

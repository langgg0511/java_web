package epms.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import sun.rmi.log.LogInputStream;

import epms.login.entity.User;
import epms.login.service.LoginService;
import epms.login.service.impl.LoginServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		User user=new User(number,password);
		
		LoginService service=new LoginServiceImpl();
		boolean flag=service.login(user);
		if(flag){
			request.getServletContext().setAttribute("number", number);
			request.getServletContext().setAttribute("loginPassword", password);
			response.sendRedirect("/epms/index.jsp");
		}else{
			response.getWriter().write("µÇÂ¼Ê§°Ü£¬Çë3ÃëºóÖØÐÂµÇÂ¼");
			response.setHeader("refresh", "3;/epms/login.jsp");
		}
	}

}

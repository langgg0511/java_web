package login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.entity.User;
import login.service.LoginService;
import login.service.impl.LoginServiceImpl;


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
			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		}else{
			String path=request.getContextPath();
			response.getWriter().write("µÇÂ¼Ê§°Ü£¬Çë3ÃëºóÖØÐÂµÇÂ¼");
			response.setHeader("refresh", "3;"+path+"/jsp/login.jsp");
		}
	}

}

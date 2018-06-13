package a_personalInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a_personalInfoMana.service.impl.ServiceImpl;
import login.entity.User;


public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext servletContext=request.getServletContext();
		//获取要修改密码的员工的员工号
		String number=request.getParameter("number");
		//获取原密码
		String loginPassword=(String) servletContext.getAttribute("loginPassword");
		
		//获取输入的原密码
		String oldPassword=request.getParameter("password");

		//获取新密码
		String newPassword=request.getParameter("newPassword");
		//第二次输入的密码
		String concertPassword=request.getParameter("concertPassword");
		
		//判断旧密码是否输入正确
		if(!loginPassword.equals(oldPassword)){
			String info="原密码输入错误,请重新输入";		
			servletContext.setAttribute("info", info);
			response.sendRedirect(request.getContextPath()+"/jsp/passwordError.jsp");
			return;
		}
		//判断两次输入的密码是否一致
		if(!newPassword.equals(concertPassword)&&newPassword!=null&&concertPassword!=null){
			String info="两次的新密码不一致，请重新输入";		
			servletContext.setAttribute("info", info);
			response.sendRedirect(request.getContextPath()+"/jsp/passwordError.jsp");
			return;
		}
		
		//修改密码
		User user=new User(number,newPassword);
		ServiceImpl serviceImpl=new ServiceImpl();
		int i=serviceImpl.updatePerPassword(user);
		if(i==1){
			response.getWriter().write("修改成功，请3秒后重新登录");
			response.setHeader("refresh","3;"+request.getContextPath()+"/jsp/login.jsp");
			return;
		}else{
			response.getWriter().write("修改失败，返回上一页");
			response.sendRedirect(request.getContextPath()+"/jsp/info_updatePassword.jsp");
			return;
		}
	}

}

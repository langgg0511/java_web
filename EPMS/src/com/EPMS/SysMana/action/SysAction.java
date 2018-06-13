package com.EPMS.SysMana.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import com.EPMS.SysMana.service.SysService;
import com.EPMS.SysMana.service.impl.SysServiceImpl;


public class SysAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private SysService service=new SysServiceImpl();
	
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
	
	//添加账户
	public void addAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		boolean flag=service.checkAccount(number,password);
		if(flag==false) {
			request.setAttribute("mess", "该账户已存在，请重新输入");
			request.getRequestDispatcher("/jsp/add_account.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/add_account/jsp");
		}
	}
	
	//删除账户
	public void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number=request.getParameter("number");
		boolean flag=service.deleteAccountById(number);
		if(flag==false) {
			request.setAttribute("mess", "该账户不存在，请重新输入");
			request.getRequestDispatcher("/jsp/delete_account.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/delete_account.jsp");
		}
	}
	
	//权限管理
	public void authority(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取部门
		Integer department=Integer.parseInt(request.getParameter("department"));
		//获取岗位
		Integer job=Integer.parseInt(request.getParameter("job"));
		String[] authorities=request.getParameterValues("authority");
		service.updateAuthority(department,job,authorities);
		response.sendRedirect(request.getContextPath()+"/jsp/authorization.jsp");
	}
}

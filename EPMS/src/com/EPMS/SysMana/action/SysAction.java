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
		//��ȡ����
		String methodName=request.getParameter("method");
		//��ȡ�������
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����˻�
	public void addAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number=request.getParameter("number");
		String password=request.getParameter("password");
		boolean flag=service.checkAccount(number,password);
		if(flag==false) {
			request.setAttribute("mess", "���˻��Ѵ��ڣ�����������");
			request.getRequestDispatcher("/jsp/add_account.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/add_account/jsp");
		}
	}
	
	//ɾ���˻�
	public void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number=request.getParameter("number");
		boolean flag=service.deleteAccountById(number);
		if(flag==false) {
			request.setAttribute("mess", "���˻������ڣ�����������");
			request.getRequestDispatcher("/jsp/delete_account.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/delete_account.jsp");
		}
	}
	
	//Ȩ�޹���
	public void authority(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡ����
		Integer department=Integer.parseInt(request.getParameter("department"));
		//��ȡ��λ
		Integer job=Integer.parseInt(request.getParameter("job"));
		String[] authorities=request.getParameterValues("authority");
		service.updateAuthority(department,job,authorities);
		response.sendRedirect(request.getContextPath()+"/jsp/authorization.jsp");
	}
}

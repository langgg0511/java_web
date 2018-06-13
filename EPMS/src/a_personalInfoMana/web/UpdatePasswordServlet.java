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
		//��ȡҪ�޸������Ա����Ա����
		String number=request.getParameter("number");
		//��ȡԭ����
		String loginPassword=(String) servletContext.getAttribute("loginPassword");
		
		//��ȡ�����ԭ����
		String oldPassword=request.getParameter("password");

		//��ȡ������
		String newPassword=request.getParameter("newPassword");
		//�ڶ������������
		String concertPassword=request.getParameter("concertPassword");
		
		//�жϾ������Ƿ�������ȷ
		if(!loginPassword.equals(oldPassword)){
			String info="ԭ�����������,����������";		
			servletContext.setAttribute("info", info);
			response.sendRedirect(request.getContextPath()+"/jsp/passwordError.jsp");
			return;
		}
		//�ж���������������Ƿ�һ��
		if(!newPassword.equals(concertPassword)&&newPassword!=null&&concertPassword!=null){
			String info="���ε������벻һ�£�����������";		
			servletContext.setAttribute("info", info);
			response.sendRedirect(request.getContextPath()+"/jsp/passwordError.jsp");
			return;
		}
		
		//�޸�����
		User user=new User(number,newPassword);
		ServiceImpl serviceImpl=new ServiceImpl();
		int i=serviceImpl.updatePerPassword(user);
		if(i==1){
			response.getWriter().write("�޸ĳɹ�����3������µ�¼");
			response.setHeader("refresh","3;"+request.getContextPath()+"/jsp/login.jsp");
			return;
		}else{
			response.getWriter().write("�޸�ʧ�ܣ�������һҳ");
			response.sendRedirect(request.getContextPath()+"/jsp/info_updatePassword.jsp");
			return;
		}
	}

}

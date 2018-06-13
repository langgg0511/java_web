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
 * ��ȡ���ݿ��е�Ա����Ϣ��
 * @author guo7jun
 *
 */
public class EmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		
		//��ȡԱ����Ϣ
		ServiceImpl serviceImpl=new ServiceImpl();
		List<Employee> list=(List<Employee>)serviceImpl.queryEmpInfo();
	
		
		//�ѻ�ȡ����Ա����Ϣ�洢���������
		context.setAttribute("list", list);
		//�ض���EmpInfoList.jsp��
		response.sendRedirect("/epms/EmpInfoList.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

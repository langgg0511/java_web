package epms.b_empInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.service.impl.ServiceImpl;


public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		ServletContext context=request.getServletContext();
		int i=0;//�����ж�Ա����Ϣ�Ƿ���ӳɹ�
		String info="";//��ʾ��Ϣ
		try {
			//��ȡ��Ҫ��ӵ�Ա����Ϣ
			int eid = new Integer(request.getParameter("eid"));
			String name = request.getParameter("empName");
			int age = new Integer(request.getParameter("age"));
			String sex = request.getParameter("sex");
			int deptid = new Integer(request.getParameter("deptid"));
			int jobid = new Integer(request.getParameter("jobid"));
			int time = new Integer(request.getParameter("time"));
			EmployeeInfo employeeInfo=new EmployeeInfo(eid, name, age, sex, deptid, jobid, time);
			//����Ϣ��ӵ����ݿ���
			ServiceImpl serviceImpl=new ServiceImpl();
			 i=serviceImpl.addEmp(employeeInfo);
		} catch (Exception e) {
			info="Ա���š����䡢����ʱ�䲻��Ϊ���������ݣ�3�������������";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoAddPage.jsp");
			return;
		}
		if(i==1){
			info="��ӳɹ�";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoAddPage.jsp");
			return;
		}else{
			info="���ʧ��,�Ѵ��ڸ�Ա���ţ�����������";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoAddPage.jsp");
			return;
		}
		
	}

}

package epms.b_empInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.service.impl.ServiceImpl;


public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		String info="";
		int i;
		try{
			int eid=new Integer(request.getParameter("eid"));
			EmployeeInfo emp=new EmployeeInfo();
			emp.setEid(eid);
			ServiceImpl serviceImpl=new ServiceImpl();
			 i=serviceImpl.deleteEmp(emp);
			
		}catch(Exception e){
			info="不能输入非数字数据,请3秒后重新输入";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoDeletePage.jsp");
			return;
		}
		if(i==1){
			info="删除成功";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoDeletePage.jsp");
			return;
		}else{
			info="删除失败";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoDeletePage.jsp");
			return;
		}
	}

}

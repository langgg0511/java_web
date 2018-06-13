package epms.b_empInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epms.b_empInfoMana.entity.EmployeeInfo;
import epms.b_empInfoMana.service.impl.ServiceImpl;


public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		int i=0;//用来判断员工信息是否添加成功
		String info="";//提示信息
		try {
			//获取需要添加的员工信息
			int eid = new Integer(request.getParameter("eid"));
			String name = request.getParameter("empName");
			int age = new Integer(request.getParameter("age"));
			String sex = request.getParameter("sex");
			int deptid = new Integer(request.getParameter("deptid"));
			int jobid = new Integer(request.getParameter("jobid"));
			int time = new Integer(request.getParameter("time"));
			EmployeeInfo employeeInfo=new EmployeeInfo(eid, name, age, sex, deptid, jobid, time);
			//把信息添加到数据库中
			ServiceImpl serviceImpl=new ServiceImpl();
			 i=serviceImpl.updateEmp(employeeInfo);
		} catch (Exception e) {
			info="员工号、年龄、工作时间不能为非数字数据，3秒后请重新输入";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoUpdatePage.jsp");
			return;
		}
		if(i==1){
			info="修改成功";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoUpdatePage.jsp");
			return;
		}else{
			info="修改失败，不存在该员工号，3秒后请重新输入";
			context.setAttribute("info", info);
			response.sendRedirect("/epms/EmpInfoUpdatePage.jsp");
			return;
		}
		
	}

}

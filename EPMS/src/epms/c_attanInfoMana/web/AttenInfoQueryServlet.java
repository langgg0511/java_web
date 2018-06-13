package epms.c_attanInfoMana.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epms.c_attanInfoMana.entity.Attendance;
import epms.c_attanInfoMana.service.impl.ServiceImpl;


public class AttenInfoQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		//获取要查询的员工号、年份、月份
		int eid=new Integer(request.getParameter("eid"));
		int year=new Integer(request.getParameter("year"));
		int month=new Integer(request.getParameter("month"));
		Attendance attendance=new Attendance();
		attendance.setEid(eid);
		attendance.setYear(year);
		attendance.setMonth(month);
		//获取要查询的员工号、年份、月份的考勤信息
		ServiceImpl serviceImpl=new ServiceImpl();
		List<Attendance> list =serviceImpl.queryAttanInfo(attendance);
		//判断是否存在该员工在某年某月的考勤信息
		if(list==null){
			String info="没有"+eid+"在"+year+"年"+month+"月的考勤信息,请3秒后重新查询";
			context.setAttribute("info",info);
			response.sendRedirect("/epms/AttenInfoPage.jsp");
			return;
		}else{
			Attendance attendance2=list.get(0);		
			context.setAttribute("attendance", attendance2);
			response.sendRedirect("/epms/AttenInfoList.jsp");
			return;
		}
	
	}

}

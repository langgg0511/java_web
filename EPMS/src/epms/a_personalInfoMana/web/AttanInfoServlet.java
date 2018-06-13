package epms.a_personalInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.inject.Context;

import epms.a_personalInfoMana.entity.Attendance;
import epms.a_personalInfoMana.service.impl.ServiceImpl;
import epms.login.entity.User;


public class AttanInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext servletContext=request.getServletContext();
		int eid=new Integer((String)servletContext.getAttribute("number"));
		int year=new Integer(request.getParameter("year"));
		int month=new Integer(request.getParameter("month"));
		Attendance attendance=new Attendance();
		attendance.setEid(eid);
		attendance.setYear(year);
		attendance.setMonth(month);
		ServiceImpl serviceImpl=new ServiceImpl();
		Attendance attendance2=serviceImpl.QueryAttendanceInfo(attendance);
		servletContext.setAttribute("attendance", attendance2);
		response.sendRedirect("/epms/info_kaoqin_list.jsp");
	}

}

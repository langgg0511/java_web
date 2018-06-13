package c_attanInfoMana.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import c_attanInfoMana.entity.Attendance;
import c_attanInfoMana.service.impl.ServiceImpl;

public class AttenUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		String info="修改失败";
		int eid=new Integer(request.getParameter("eid"));
		int year=new Integer(request.getParameter("year"));
		int month=new Integer(request.getParameter("month"));
		int prinday=new Integer(request.getParameter("prin_day"));
		int ondutyday=new Integer(request.getParameter("onduty_day"));
		int absenteeism=new Integer(request.getParameter("absenteeism"));
		int leave=new Integer(request.getParameter("leave"));
		int overtime=new Integer(request.getParameter("overtime"));
		ServiceImpl serviceImpl=new ServiceImpl();
		Attendance attendance=new Attendance(eid, year, month, prinday, absenteeism, leave, ondutyday, overtime);
		int i=serviceImpl.updateAttanInfo(attendance);
		if(i==1){
			 info="修改成功,3秒后返回上一页";
		}else{
			 info="修改失败,3秒后返回上一页";
		}
		context.setAttribute("info", info);
		response.sendRedirect(request.getContextPath()+"/jsp/AttenInfoUpdatePage.jsp");
	}

}

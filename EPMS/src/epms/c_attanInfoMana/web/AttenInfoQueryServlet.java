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
		//��ȡҪ��ѯ��Ա���š���ݡ��·�
		int eid=new Integer(request.getParameter("eid"));
		int year=new Integer(request.getParameter("year"));
		int month=new Integer(request.getParameter("month"));
		Attendance attendance=new Attendance();
		attendance.setEid(eid);
		attendance.setYear(year);
		attendance.setMonth(month);
		//��ȡҪ��ѯ��Ա���š���ݡ��·ݵĿ�����Ϣ
		ServiceImpl serviceImpl=new ServiceImpl();
		List<Attendance> list =serviceImpl.queryAttanInfo(attendance);
		//�ж��Ƿ���ڸ�Ա����ĳ��ĳ�µĿ�����Ϣ
		if(list==null){
			String info="û��"+eid+"��"+year+"��"+month+"�µĿ�����Ϣ,��3������²�ѯ";
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

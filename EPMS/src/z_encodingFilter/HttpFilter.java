package z_encodingFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter{
	//���ڱ���filterConfig����
	private FilterConfig filterConfig;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//ԭ����doFilter�������ڷ����ڲ���ServletRequest,ServletResponse
	//תΪHttpServletRequest��HttpServletResponse��������doFilter
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		doFilter(request,response,chain);
	}

	//���󷽷�����ʵ��
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,
			FilterChain filterChain)throws IOException, ServletException;
	//����������ֱ�Ӹ��ǣ���ֱ�Ӹ��ǣ������ܵ���filterConfig��Ա������ʼ��ʧ��
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig=arg0;
		init();
		
	}
	//������̳г�ʼ������������ͨ��getFilterConfig()��ȡFilterConfig����
	protected void init() {}
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	
}

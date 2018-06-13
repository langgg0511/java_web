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
	//用于保存filterConfig对象
	private FilterConfig filterConfig;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	//原生的doFilter方法，在方法内部把ServletRequest,ServletResponse
	//转为HttpServletRequest，HttpServletResponse，并调用doFilter
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		doFilter(request,response,chain);
	}

	//抽象方法必须实现
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,
			FilterChain filterChain)throws IOException, ServletException;
	//不建议子类直接覆盖，若直接覆盖，将可能导致filterConfig成员变量初始化失败
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig=arg0;
		init();
		
	}
	//供子类继承初始化方法，可以通过getFilterConfig()获取FilterConfig对象
	protected void init() {}
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	
}

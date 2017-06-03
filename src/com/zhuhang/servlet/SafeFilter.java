package com.zhuhang.servlet;

/*import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class SafeFilter implements Filter {

    public SafeFilter() {
    }

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		StringBuffer string = request2.getRequestURL();
		String string2 = string.toString();
		if(!string2.contains("login"))
		{
			HttpSession session = request2.getSession();
			if(session.getAttribute("sno") == null) return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}*/

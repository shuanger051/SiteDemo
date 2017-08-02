package cn.qweb.cms.core.filter;

/**
 * @author Tom
 */


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XssFilter extends OncePerRequestFilter {
	/**
	 * Same contract as for {@code doFilter}, but guaranteed to be
	 * just invoked once per request within a single request thread.
	 * See {@link #shouldNotFilterAsyncDispatch()} for details.
	 * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
	 * default ServletRequest and ServletResponse ones.
	 *
	 * @param request
	 * @param response
	 * @param filterChain
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		filterChain.doFilter(new XssHttpServletRequestWrapper(request), response);
	}


//	private String excludeUrls;
//	FilterConfig filterConfig = null;
//	public void init(FilterConfig filterConfig) throws ServletException {
//		this.excludeUrls=filterConfig.getInitParameter("excludeUrls");
//		this.filterConfig = filterConfig;
//	}
//
//	public void destroy() {
//		this.filterConfig = null;
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
//	}


	

}

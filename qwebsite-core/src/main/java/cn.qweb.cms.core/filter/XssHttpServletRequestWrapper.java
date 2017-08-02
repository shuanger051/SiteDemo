package cn.qweb.cms.core.filter;


import cn.qweb.cms.core.utils.StrUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * @author Tom
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	public String getQueryString() {
		String value = super.getQueryString();
		if (value != null) {
			value = StrUtil.escapeHtml(value);
		}
		return value;
	}
	
	/**
	 * 覆盖getParameter方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getParameterValues(name)来获取<br/>
	 * getParameterNames,getParameterValues和getParameterMap也可能需要覆盖
	 */
	public String getParameter(String name) {
		String value = super.getParameter(StrUtil.escapeHtml(name));
		if (value != null) {
			value = StrUtil.escapeHtml(value);
		}
		return value;
	}
	
	public String[] getParameterValues(String name) {
		String[]parameters=super.getParameterValues(name);
		if (parameters==null||parameters.length == 0) {
			return null;
		}
		for (int i = 0; i < parameters.length; i++) {
			parameters[i] = StrUtil.escapeHtml(parameters[i]);
		}
		return parameters;
	}
	
	/**
	 * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/>
	 * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/> getHeaderNames 也可能需要覆盖
	 */
//	public String getHeader(String name) {
//
//		String value = super.getParameter(StrUtil.escapeHtml(name));
//		if (value != null) {
//			value = StrUtil.escapeHtml(value);
//		}
//		return value;
//	}
	
	
}

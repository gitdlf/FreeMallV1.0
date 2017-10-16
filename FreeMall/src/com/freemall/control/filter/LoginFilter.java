package com.freemall.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录过滤器，如果没有登录禁止访问servlet下的所有文件 判断是否有登录标识：LOGINTAG Servlet Filter
 * implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	private String[] exceptionPage;

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object loginAttribute = session.getAttribute("LOGINTAG");
		if (loginAttribute == null || "".equals(loginAttribute)) {
			for (int i = 0; i < exceptionPage.length; i++) {
				if (req.getRequestURI().contains(exceptionPage[i])) {
					// 返回一个错误编码同时发送转发头
					//发送302状态吗，让添加购物车的时候，如果没登录跳转到登录界面
					 ((HttpServletResponse)response).setStatus(302);
					req.getRequestDispatcher("/page/user/login.jsp").forward(
							request, response);
					return;
				}
			}
			chain.doFilter(req, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		exceptionPage = fConfig.getInitParameter("exceptionPage").split(",");
	}

}

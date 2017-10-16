package com.freemall.control.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码过滤器
 * Servlet Filter implementation class EncodeFilter
 */
public class EncodeFilter implements Filter {
	private String encoding;

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		final HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		res.setContentType("text/html;charset="+encoding);
		req.setCharacterEncoding(encoding);
		HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// 定义方法返回值
				Object returnValue = null;
				// 获取方法名
				String methodName = method.getName();
				// 判断：对getParameter方法进行GET提交中文处理
				if ("getParameter".equals(methodName)) {
					
					// 获取请求数据值【 <input type="text" name="userName">】
					String value = req.getParameter(args[0].toString());	// 调用目标对象的方法
					
					// 获取提交方式
					String methodSubmit = req.getMethod(); // 直接调用目标对象的方法
					
					// 判断如果是GET提交，需要对数据进行处理  (POST提交已经处理过了)
					if ("GET".equals(methodSubmit)) {
						if (value != null && !"".equals(value.trim())){
							// 处理GET中文
							value = new String(value.getBytes("ISO8859-1"),encoding);
						}
					} 
					return value;
				}
				else {
					// 执行request对象的其他方法
					returnValue = method.invoke(req, args);
				}
				
				return returnValue;
			}
		});
		chain.doFilter(proxy, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=fConfig.getInitParameter("encoding");
	}

}

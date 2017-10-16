package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出登录
 * url-patter：outlogin
 * @author LFSenior
 *
 *上午10:12:35
 *
 */
public class OutLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7108312836970683946L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//删除JSSIONID的cookie达到退出登陆的效果
		Cookie cookie=new Cookie("JSESSIONID", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		//跳转到主页		
		response.sendRedirect(request.getContextPath()+"/index");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

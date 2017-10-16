package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 主页servlet
 * url-mapping
 * index
 * @author LFSenior
 *
 *上午10:04:54
 *
 */
public class IndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086383858306695221L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	模拟获得购物车数据		
		/*List<CartEntry> CARTTAG=new ArrayList<CartEntry>();
		CARTTAG.add(new CartEntry("/images/lfsenior_test/test1.jpg","经典落地扇",25.5));
		CARTTAG.add(new CartEntry("/images/lfsenior_test/test2.jpg","经典小风扇",25.5));
		CARTTAG.add(new CartEntry("/images/lfsenior_test/test1.jpg","高级冷风扇",25.5));
		request.getSession().setAttribute("CARTTAG", CARTTAG);*/
		
		/*//  模拟登录数据
		UserEntry LOGINTAG=new UserEntry();
		LOGINTAG.setUserName("lfsenior");
		request.getSession().setAttribute("LOGINTAG", LOGINTAG);*/
		//重定向到主页
		request.getRequestDispatcher("/page/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

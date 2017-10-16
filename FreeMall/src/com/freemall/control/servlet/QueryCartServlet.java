package com.freemall.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.cart.QueryCartService;

/**
 * 查看购物车的servlet
 * @author LFSenior
 *
 *下午5:27:17
 *
 */
public class QueryCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1153431578471943812L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取登录对象
		UserEntry loginUser=(UserEntry) request.getSession().getAttribute("LOGINTAG");
		//如果loginUser==null
		if(loginUser==null || "".equals(loginUser)){
			//跳转到登录页面
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
			return ;
		}
		//查询数据库
		List<CartEntry> CARTTAG = new QueryCartService().queryCart(loginUser);
		request.getSession().setAttribute("CARTTAG", CARTTAG);
		request.getRequestDispatcher("/page/shop/basket.jsp").forward(request, response);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

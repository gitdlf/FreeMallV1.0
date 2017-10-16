package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.cart.DelCartService;


/**
 * 删除购物车项的servlet
 * @author LFSenior
 *
 *下午8:12:53
 *
 */
public class DelCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5058647846345820650L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取购物车项id
		String cartId = request.getParameter("cartid");
		//获取登录对象
		UserEntry loginUser=(UserEntry) request.getSession().getAttribute("LOGINTAG");
		CartEntry cartEntry=new CartEntry();
		//封装购物车id
		cartEntry.setCartId(Integer.parseInt(cartId));
		//封装用户id
		cartEntry.setUserId(loginUser.getUserId());
		//调用删除方法
		boolean delCartPin = new DelCartService().delProForCart(cartEntry);
		if(delCartPin){
			response.setStatus(200);
			request.getRequestDispatcher("/control/querycart").forward(request, response);
		}else{
			response.setStatus(302);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

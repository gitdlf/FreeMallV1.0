package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.order.QueryOrderByOrderNoService;

/**
 * 跳转到评论页面的servlet
 * 
 * @author LFSenior
 * 
 *         下午5:13:52
 * 
 */
public class CommintServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -443066304547424732L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取订单编号
		String orderNo = request.getParameter("orderno");
		// 校验订单编号
		if (orderNo == null || "".equals(orderNo.trim())) {
			// 说明有误，跳转到订单页
			request.getRequestDispatcher("/control/queryorder").forward(
					request, response);
			return;
		}

		// 获取操作码
		String option = request.getParameter("option");
		// 校验操作码
		if (option == null || "".equals(option.trim())) {
			// 说明有误，跳转到订单页
			request.getRequestDispatcher("/control/queryorder").forward(
					request, response);
			return;
		}
		// 根据操作码选择对应操作
		switch (option) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		default:
		}

		// 获取登录用户数据
		UserEntry loginUser = (UserEntry) request.getSession().getAttribute(
				"LOGINTAG");
		// 封装订单类
		OrderEntry ORDERCOMMENTENTRY = new OrderEntry();
		// 封装用户id
		ORDERCOMMENTENTRY.setUserId(loginUser.getUserId());
		// 封装订单No
		ORDERCOMMENTENTRY.setOrderNo(orderNo);
		// 查询
		if (new QueryOrderByOrderNoService()
				.queryOrderByOrderNo(ORDERCOMMENTENTRY)) {
			// 将数据保存在域中
			request.setAttribute("ORDERCOMMENTENTRY", ORDERCOMMENTENTRY);
			// 成功/FreeMall/WebRoot
			request.getRequestDispatcher("/page/shop/orderevaluate.jsp")
					.forward(request, response);
			return;
		} else {
			// 说明有误，跳转到订单页
			request.getRequestDispatcher("/control/queryorder").forward(
					request, response);
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.freemall.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.order.QueryAllOrderService;
import com.freemall.service.order.QueryOrderByStateService;
import com.freemall.util.OrderState;

public class QueryOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4231783614952363747L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//封装用户提交的数据
		//订单状态
		String ORDERSTATE = request.getParameter("orderstate");
		//如果ordestate为null或者为空在，则说明查询的时候所有订单数据
		if(ORDERSTATE==null||"".equals(ORDERSTATE.trim())){
			ORDERSTATE=String.valueOf(OrderState.ALLSTATE);
		}
		//获取用户idLOGINTAG
		UserEntry loginUser = (UserEntry) request.getSession().getAttribute("LOGINTAG");
		//所有订单信息的list集合
		List<OrderEntry> ORDERLIST=new ArrayList<OrderEntry>();
		//判定订单状态
		if(ORDERSTATE.equals(String.valueOf(OrderState.ALLSTATE))){
			//说明是查询所有状态的订单
			ORDERLIST=new QueryAllOrderService().getAllOrder(loginUser.getUserId());
		}else{
			//说明按状态查询订单
			ORDERLIST=new QueryOrderByStateService().getOrderByState(Integer.parseInt(ORDERSTATE), loginUser.getUserId());
		}
		//将用户选择的状态的编码发送给jsp页面
		request.setAttribute("ORDERSTATE", ORDERSTATE);
		//将订单数据发送到request域中
		request.setAttribute("ORDERLIST", ORDERLIST);
		/*//模拟测试数据，查看是否正确
		for (OrderEntry orderEntry : ORDERLIST) {
			System.out.println(orderEntry);
		}*/
		//转发
		request.getRequestDispatcher("/page/shop/order.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

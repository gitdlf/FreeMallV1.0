package com.freemall.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.UpdateCartByCartIdDao;
import com.freemall.service.cart.QueryCartService;
import com.freemall.service.mail.OrderSendMail;
import com.freemall.service.order.AddOrderService;
import com.freemall.util.OrderUtil;

/**
 * 增加订单的servlet
 * 更具用户传递的购物车项来生成id
 * @author LFSenior
 *
 *上午10:11:52
 *
 */
public class AddOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351166695221592009L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户添加到订单中的购物车项的id
		String[] cartIdList = request.getParameterValues("cartlist");
		//订单项数据校验
		if(cartIdList==null||cartIdList.length==0){
			//失败返回
			request.getRequestDispatcher("/control/querycart").forward(request, response);
			return ;
		}
		//从session对象中获取LOGINTAG，的登录UserEntry
		UserEntry loginUser=(UserEntry) request.getSession().getAttribute("LOGINTAG");
		//封装购物车项集合
		List<CartEntry> cartEntryList=new ArrayList<CartEntry>();
		for(int i=0;i<cartIdList.length;i++){
			CartEntry cartEntry=new CartEntry();
			//封装购物车id
			cartEntry.setCartId(Integer.parseInt(cartIdList[i]));
			//封装数量
			String proCount=request.getParameter("proNum"+cartIdList[i]);
			if(proCount==null||"".equals(proCount.trim())){
				//失败返回
				request.getRequestDispatcher("/control/querycart").forward(request, response);
				return ;
			}
			cartEntry.setProCount(Integer.parseInt(proCount));
			cartEntryList.add(cartEntry);
		}
		
		//更新购物车
		for (CartEntry cartEntry : cartEntryList) {
			new UpdateCartByCartIdDao().updateCartByCartId(cartEntry);
		}
		//获取订单状态
		String orderState = request.getParameter("orderstate");
		//判定订单状态,如果为空，或者null，则设置订单状态为1
		if(orderState==null||"".equals(orderState.trim())){
			orderState="3";
		}
		
		
		
		//封装OrderEntry对象
		OrderEntry orderEntry=new OrderEntry();
		//封装订单No
		orderEntry.setOrderNo(OrderUtil.getOrderNoByUUId());
		//封装用户id
		orderEntry.setUserId(loginUser.getUserId());
		//封装订单状态
		orderEntry.setStatusName(Integer.parseInt(orderState));
		//封装订单创建者
		orderEntry.setCreateAuthor(loginUser.getUserName());
		//封装订单地址
		orderEntry.setAddress(loginUser.getUserAddress());
		//封装订单包含的cartIdList
		orderEntry.setCartIdList(cartIdList);
		//提交订单
		if(new AddOrderService().addOrder(orderEntry)){
			//成功
			//查询购物侧
			List<CartEntry> CARTTAG = new QueryCartService().queryCart(loginUser);
			//更新session中的CARTTAG标识
			request.getSession().setAttribute("CARTTAG", CARTTAG);
			//封装CartList
			//向用户发送邮件
			new OrderSendMail().orderSendMail(orderEntry, loginUser);
			request.getRequestDispatcher("/page/shop/doBuy.jsp").forward(request, response);
		}else{
			//失败返回
			request.getRequestDispatcher("/control/querycart").forward(request, response);
			return ;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

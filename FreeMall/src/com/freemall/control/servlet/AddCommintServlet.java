package com.freemall.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.MessageEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.order.AddCommintService;

/**
 * 添加评论的servlet
 * @author LFSenior
 *
 *下午7:36:11
 *
 */
public class AddCommintServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4338261781599444602L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取商品id集合
		String[] proIdList = request.getParameterValues("proIdList");
		//数据校验
		if(proIdList.length<=0){
			//跳转
			request.getRequestDispatcher("/control/queryorder").forward(request, response);
			return ;
		}
		//封装MessageList
		List<MessageEntry> messageList=new ArrayList<MessageEntry>();
		//获取登录对象
		UserEntry loginUser=(UserEntry) request.getSession().getAttribute("LOGINTAG");
		//校验
		if(loginUser==null){
			//跳转
			request.getRequestDispatcher("/control/queryorder").forward(request, response);
			return ;
		}
		for(String proid:proIdList){
			//获取当前商品的星级
			String state = request.getParameter("state"+proid);
			if(state==null||"".equals(state.trim())){
				//设置默认值
				state="0";
			}
			//获取评论信息
			String content = request.getParameter("message"+proid);
			if(content==null||"".equals(content.trim())){
				//如果没有评论信息不进行插入操作
				continue;
			}
			//创建封装对象messageid,content,userid,goodsid,createauthor,userstate
			MessageEntry messageEntry=new MessageEntry();
			//封装商品id
			messageEntry.setGoodsId(Integer.parseInt(proid));
			//封装商品信息
			messageEntry.setContent(content);
			//封装用户评论星级
			messageEntry.setUserState(Integer.parseInt(state));
			messageEntry.setUserId(loginUser.getUserId());
			messageEntry.setCreateAuthor(loginUser.getUserName());
			messageList.add(messageEntry);
		}
		for (MessageEntry messageEntry : messageList) {
			//将封装的信息，插入到表中
			new AddCommintService().addCommentMessage(messageEntry);
		}
		//跳转到订单页面
		request.getRequestDispatcher("/control/queryorder").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

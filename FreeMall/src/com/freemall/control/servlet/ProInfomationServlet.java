package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.service.search.ProInfomationService;

/**
 * 商品详情展示
 * @author LFSenior
 *
 *上午11:27:19
 *
 */
public class ProInfomationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6773274212820290209L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取goodsId商品id
		String goodsId=request.getParameter("goodsId");
		//调用getProinfomation方法，获得商品数据
		GoodsEntry goodsInfo = new ProInfomationService().getProInfomation(goodsId);
		request.setAttribute("GOODSINFO", goodsInfo);
		if(goodsInfo==null){
			request.getRequestDispatcher("/index").forward(request, response);
		}else{
			request.getRequestDispatcher("/page/shop/goodsinfo.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

package com.freemall.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.PageBean;
import com.freemall.service.search.SearchService;

/**
 * 关键字搜索servlet
 * 
 * @author LFSenior
 * 
 *         下午3:57:46
 * 
 */
public class SearchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9059365563993942208L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取到关键字
		String KEYWORDS = request.getParameter("keywords");
		// 获取当前页面
		String currPage = request.getParameter("pg");
		// 如果pg不存在说明是第一页
		if (currPage == null || "".equals(currPage.trim())) {
			currPage = "1";
		}
		// 封装PageBean
		PageBean PAGEBEAN = new PageBean();
		PAGEBEAN.setCurrentPage(Integer.parseInt(currPage));
		// 页面展示商品集合
		List<GoodsEntry> GOODSLIST = new ArrayList<GoodsEntry>();
		//调用搜索服务，接收商品信息
		GOODSLIST=new SearchService().getGoodsBySearch(KEYWORDS, PAGEBEAN);
		//将数据保存到域中
		request.setAttribute("PAGEBEAN", PAGEBEAN);
		request.setAttribute("GOODSLIST", GOODSLIST);
		//用于数据回显
		request.setAttribute("KEYWORDS", KEYWORDS);
		/*//模拟查看数据
		for (GoodsEntry goodsEntry : GOODSLIST) {
			System.out.println(goodsEntry.getGoodsId());
		}
		System.out.println("当前页码"+PAGEBEAN.getCurrentPage());
		System.out.println("最大页码"+PAGEBEAN.getTotalPage());
		System.out.println(GOODSLIST.size());*/
		//转发到商品显示页面；但是得用search的商品显示页面
		request.getRequestDispatcher("/page/shop/searchproductlist.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

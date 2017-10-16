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
import com.freemall.service.search.GetProductByCateService;

/**
 * 商品分类检索servlet
 * @author LFSenior
 *
 *上午10:04:19
 *
 */
public class CateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -915242984581950683L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取分类类型[parent,child],分类id
		String cate = request.getParameter("cate");
		String cateid = request.getParameter("cateid");
		//获取当前页面
		String currPage=request.getParameter("pg");
		//如果pg不存在说明是第一页
		if(currPage==null||"".equals(currPage.trim())){
			currPage="1";
		}
		//封装PageBean
		PageBean PAGEBEAN=new PageBean();
		PAGEBEAN.setCurrentPage(Integer.parseInt(currPage));
		//页面展示商品集合
		List<GoodsEntry> GOODSLIST=new ArrayList<GoodsEntry>();
		if("child".equals(cate.trim())){
			//表示子类分类
			GOODSLIST=new GetProductByCateService().getProductChild(Integer.parseInt(cateid), PAGEBEAN);
		}
		if("parent".equals(cate.trim())){
			//表示父分类
			GOODSLIST=new GetProductByCateService().getProductParent(Integer.parseInt(cateid), PAGEBEAN);
		}
		//将所有数据保存到request域中
		if(GOODSLIST.size()==0){
			//说明没有数据
			//返回空
			GOODSLIST=null;
		}
		//封装cateid与cate数据
		request.setAttribute("CATE", cate);
		request.setAttribute("CATEID", cateid);
		request.setAttribute("PAGEBEAN", PAGEBEAN);
		request.setAttribute("GOODSLIST", GOODSLIST);
		/*//模拟查看数据
		for (GoodsEntry goodsEntry : GOODSLIST) {
			System.out.println(goodsEntry.getGoodsId());
		}
		System.out.println("当前页码"+PAGEBEAN.getCurrentPage());
		System.out.println("最大页码"+PAGEBEAN.getTotalPage());
		System.out.println(GOODSLIST.size());*/
		//转发到商品显示列
		request.getRequestDispatcher("/page/shop/productlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

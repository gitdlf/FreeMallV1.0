package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.GoodsEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.AddProToCartService;
import com.freemall.dao.imp.GetProByProIdDao;

/**
 * 添加商品到购物车处理servlet
 * @author LFSenior
 *
 *上午8:15:23
 *
 */
public class AddProToCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66998607918355895L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//商品id		
		String goodsId=request.getParameter("goodsId");
		//校验数据为null或为“”返回303状态码
		if(goodsId==null||"".equals(goodsId.trim())){
			response.setStatus(303);
			return ;
		}
		//商品数量
		String proNum=request.getParameter("proNum");
		//校验数据为null或为“”返回303状态码
		if(proNum==null||"".equals(proNum.trim())){
			response.setStatus(303);
			return ;
		}
		//用户数据
		UserEntry loginUser=(UserEntry) request.getSession().getAttribute("LOGINTAG");
		//商品数据
		GoodsEntry goodsEntry=new GetProByProIdDao().getProByProId(goodsId);
		if(goodsEntry==null){
			response.setStatus(303);
			return ;
		}
		//封装数据
		//cartid,proname,proprice,procount,userid,proid,createauthor
		CartEntry cartEntry=new CartEntry();
		//封装商品名
		cartEntry.setProName(goodsEntry.getGoodsName());
		//封装商品价格
		cartEntry.setProPrice(goodsEntry.getPrice());
		//封装商品数量
		cartEntry.setProCount(Integer.parseInt(proNum));
		//封装用户id
		cartEntry.setUserId(loginUser.getUserId());
		//封装商品id
		cartEntry.setProId(goodsEntry.getGoodsId());
		//封装创建者
		cartEntry.setCreateAuthor(loginUser.getUserName());
		//成功返回200状态码
		if(new AddProToCartService().addProToCart(cartEntry)){
			response.setStatus(200);
			return ;
		}else{
			response.setStatus(303);
			return ;
		}
		//失败返回303状态码
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

package com.freemall.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.freemall.dao.entry.IndexContentEntry;
import com.freemall.service.init.InitContentService;

/**
 * 初始化中区域信息
 * @author LFSenior
 *
 *上午9:00:32
 *
 */
public class InitIndexContentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4395750456471345005L;

	@Override
	public void init() throws ServletException {
		//初始化数据
		ServletContext servletContext = this.getServletContext();
		List<IndexContentEntry> INDEXCONTENTINFO=new InitContentService().getIndexContentList(servletContext.getRealPath("/config/indexContentConfig.xml"));
		servletContext.setAttribute("INDEXCONTENTINFO", INDEXCONTENTINFO);
		System.out.println("主页content区域内容已填充");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

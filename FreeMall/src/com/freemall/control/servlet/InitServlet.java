package com.freemall.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.BannerEntry;
import com.freemall.dao.entry.ParentCateEntry;
import com.freemall.service.init.InitService;

/**
 * 初始化主页数据的servlet
 * @author LFSenior
 *
 *下午2:47:00
 *
 */
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3176012646349132651L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//调用初始化服务获取到主页导航分类的数据
		List<ParentCateEntry> INDEXCATEGORY=new InitService().getIndexCateNav();
		//获取context域对象
		ServletContext servletContext = this.getServletContext();
		//调用初始化服务获取到主页轮播图数据并
		List<BannerEntry> INDEXBANNER =new InitService().getBannerDate(servletContext.getRealPath("/config/indexBannerConfig.xml")); 
		//调用初始化服务获取到主页热卖关键字
		List<String> HOTKEYWORDS = new InitService().getHotKeywordDate(servletContext.getRealPath("/config/hotKeyWordsConfig.xml"));
		//将HOTKEYWORDS数据保存到context域中
		servletContext.setAttribute("HOTKEYWORDS", HOTKEYWORDS);
		//将INDEXCATEGORY数据保存到context域中
		servletContext.setAttribute("INDEXCATEGORY", INDEXCATEGORY);
		//将INDEXBANNER数据保存到context域中
		servletContext.setAttribute("INDEXBANNER", INDEXBANNER);
		//在控制台打印提示信息提示信息
		System.out.println("主页导航分类数据初始化完成");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

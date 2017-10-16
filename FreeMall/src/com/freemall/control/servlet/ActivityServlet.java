package com.freemall.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freemall.dao.entry.ActivityEntry;
import com.freemall.service.activities.ActivityService;

/**
 * 活动servlet
 * @author LFSenior
 *
 *上午10:07:43
 *
 */
public class ActivityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2646821609034330310L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取活动编号
		String activityNo = request.getParameter("activityNo");
		//校验活动编号
		if(activityNo==null||"".equals(activityNo.trim())){
			//错误跳转到首页
			request.getRequestDispatcher("/index").forward(request, response);
			return;
		}		
		//更具活动编号获取活动内容
		ActivityEntry activityEntry=new ActivityService().getActivity(activityNo);
		//将活动信息保存到页面总
		request.setAttribute("ACTIVITYENTRY", activityEntry);
		request.getRequestDispatcher("/page/shop/activite.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

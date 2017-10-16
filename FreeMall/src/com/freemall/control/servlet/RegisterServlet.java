package com.freemall.control.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.SqlDateLocaleConverter;

import com.freemall.dao.entry.UserEntry;
import com.freemall.service.mail.RegisterSendMail;
import com.freemall.service.user.RegisterService;

/**
 * 注册servlet
 * @author LFSenior
 *
 *下午12:31:15
 *
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4949008407483872499L;

	@SuppressWarnings({ "rawtypes" })
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有信息
		Map parameterMap = request.getParameterMap();
		//创建对象
		UserEntry userEntry=new UserEntry();
		//注册sql日期装换器
		ConvertUtils.register(new SqlDateLocaleConverter(), Date.class);
		try {
			BeanUtils.populate(userEntry, parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if(new RegisterService().register(userEntry)){
			//注册成功//在session保存用户信息LOGINTAG，并跳转到首页
			request.getSession().setAttribute("LOGINTAG", userEntry);
			//向用户发送邮件
			new RegisterSendMail().registerSendMail(userEntry);
			request.getRequestDispatcher("/index").forward(request, response);
		}else{
			//注册失败
			//保存REGISTERUSER用于数据回显
			//保存REGISTERERROR值error用于页面显示错误提示
			request.setAttribute("REGISTERUSER", userEntry);
			request.setAttribute("REGISTERERROR", "error");
			request.getRequestDispatcher("/page/user/register.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

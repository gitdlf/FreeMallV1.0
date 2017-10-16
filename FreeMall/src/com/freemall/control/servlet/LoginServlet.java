package com.freemall.control.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.service.cart.QueryCartService;
import com.freemall.service.user.LoginService;

/**
 * 登录servlet
 * @author LFSenior
 *
 *上午10:56:46
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2979221010483153758L;

	@SuppressWarnings("rawtypes")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean judge =true;
		UserEntry userEntry =new UserEntry();
		Map parameterMap = request.getParameterMap();
		ConvertUtils.register(new Converter() {
			public Object convert(Class arg0, Object arg1) {
				// TODO Auto-generated method stub
				if(java.util.Date.class==arg0){
					 try {
						if(arg1!=null){
							java.util.Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(arg1.toString());
							return new java.sql.Date(parse.getTime());
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return null;
			}
		}, java.util.Date.class);
		try {
			BeanUtils.populate(userEntry, parameterMap);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//数据不为空校验
		if(userEntry.getUserName()==null||"".equals(userEntry.getUserName().trim())){
			judge =false;
		}
		if(userEntry.getUserPwd()==null||"".equals(userEntry.getUserPwd().trim())){
			judge= false;
		}
		
		
		
		
		//通过数据不为空校验	
		//调用login方法，判断是否登录成功
		judge=new LoginService().login(userEntry);
		if(judge){
			//登录成功
			//保存登录数据
			request.getSession().setAttribute("LOGINTAG", userEntry);
			//查询购物车
			//查询数据库
			List<CartEntry> CARTTAG = new QueryCartService().queryCart(userEntry);
			//保存购物车数据
			request.getSession().setAttribute("CARTTAG", CARTTAG);
			request.getRequestDispatcher("/index").forward(request, response);
		}else{
			//登录失败
			request.setAttribute("LOGINUSER", userEntry);
			request.setAttribute("LOGINERROR", "error");
			request.getRequestDispatcher("/page/user/login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

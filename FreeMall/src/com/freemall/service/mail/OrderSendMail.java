package com.freemall.service.mail;


import java.util.List;

import com.freemall.dao.entry.CartEntry;
import com.freemall.dao.entry.MailInfo;
import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;
import com.freemall.dao.imp.QueryCartByOrderNoDao;
import com.freemall.util.MailContentUtil;
import com.freemall.util.MailSendUtil;

public class OrderSendMail implements IOrderSendMail {

	public void orderSendMail(OrderEntry orderEntry,UserEntry userEntry) {
		//获取购车集合
		List<CartEntry> cartList = new QueryCartByOrderNoDao().queryCartByOrderNo(orderEntry.getOrderNo());
		//封装购物车集合
		orderEntry.setCartEntryList(cartList);
		String mail = userEntry.getUserEmail(); // 发送对象的邮箱
		String title = "订单发货通知";
		String content=MailContentUtil.orderContent(orderEntry);
		MailInfo info = new MailInfo();
		info.setToAddress(mail);
		info.setSubject(title);
		info.setContent(content);
		try {
			MailSendUtil.sendHtmlMail(info);
		} catch (Exception e) {
			System.out.print("'" + title + "'的邮件发送失败！");
			e.printStackTrace();
		}
	}

}

package com.freemall.service.mail;

import com.freemall.dao.entry.OrderEntry;
import com.freemall.dao.entry.UserEntry;

public interface IOrderSendMail {
	public void orderSendMail(OrderEntry orderEntry,UserEntry userEntry);
}

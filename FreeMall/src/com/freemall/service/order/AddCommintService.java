package com.freemall.service.order;

import com.freemall.dao.entry.MessageEntry;
import com.freemall.dao.imp.AddCommentMessageDao;
import com.freemall.service.IAddCommintService;

/**
 * 增加评论接口
 * @author LFSenior
 *
 *下午7:57:00
 *
 */
public class AddCommintService implements IAddCommintService {

	public boolean addCommentMessage(MessageEntry messageEntry) {
		return new AddCommentMessageDao().addCommentMessage(messageEntry);
	}

}

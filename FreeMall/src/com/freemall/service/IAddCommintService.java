package com.freemall.service;

import com.freemall.dao.entry.MessageEntry;

/**
 * 增加评论service接口
 * @author LFSenior
 *
 *下午7:56:18
 *
 */
public interface IAddCommintService {
	/**
	 * 利用消息的实体类，添加商品评论信息
	 * @param messageEntry 评论信息的实体类
	 * @return 返回是否添加成功
	 */
	public boolean addCommentMessage(MessageEntry messageEntry);
}

package com.freemall.dao;

import com.freemall.dao.entry.MessageEntry;

/**
 * 增加商品评论
 * @author LFSenior
 *
 *下午4:52:20
 *
 */
public interface IAddCommentMessageDao {
	/**
	 * 利用消息的实体类，添加商品评论信息
	 * @param messageEntry 评论信息的实体类
	 * @return 返回是否添加成功
	 */
	public boolean addCommentMessage(MessageEntry messageEntry);
}

package com.freemall.dao.imp;

import com.freemall.dao.IAddCommentMessageDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.MessageEntry;

/**
 * 增加评论信息
 * @author LFSenior
 *
 *下午4:56:46
 *
 */
public class AddCommentMessageDao extends JdbcBase implements IAddCommentMessageDao {

	public boolean addCommentMessage(MessageEntry messageEntry) {
		String sql="insert into message_t (messageid,content,userid,goodsid,createauthor,userstate) values (message_s.nextval,?,?,?,?,?)";
		Integer line = update(sql, messageEntry.getContent(),messageEntry.getUserId(),messageEntry.getGoodsId(),messageEntry.getCreateAuthor(),messageEntry.getUserState());
		if(line>0){
			return true;
		}
		return false;
	}
}

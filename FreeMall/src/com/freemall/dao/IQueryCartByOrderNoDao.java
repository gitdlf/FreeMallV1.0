package com.freemall.dao;

import java.util.List;

import com.freemall.dao.entry.CartEntry;

/**
 * 根据订单No，查询购物车表，进改订单下的所有数据都查询出来
 * 
 * @author LFSenior
 *
 *下午1:30:31
 *
 */
public interface IQueryCartByOrderNoDao {
	public List<CartEntry> queryCartByOrderNo(String orderNo);
}

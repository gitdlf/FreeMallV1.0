package com.freemall.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.freemall.dao.IActivityDao;
import com.freemall.dao.JdbcBase;
import com.freemall.dao.entry.ActivityEntry;
import com.freemall.dao.entry.ActivityNoEntry;
import com.freemall.dao.entry.GoodsEntry;

/**
 * 活动ddao实现类
 * @author LFSenior
 *
 *上午10:04:27
 *
 */
public class ActivityDao extends JdbcBase implements IActivityDao {

	public ActivityEntry getActivity(String activityNo) {
		// 根据活动编号查询活动商品id
		String sql = "select proId,backgroundImagesAddress from activite_t where activiteNo=?";
		// 执行sql
		List<ActivityNoEntry> activityNoList = query(sql,
				ActivityNoEntry.class, activityNo);
		// 创建活动实体
		ActivityEntry activityEntry = new ActivityEntry();
		// 封装商品id集合
		activityEntry.setProIdList(activityNoList);
		// 创建商品集合
		List<GoodsEntry> proList = new ArrayList<GoodsEntry>();
		/**
		 * 遍历活动商品集合，查询商品详细信息
		 */
		for (ActivityNoEntry activityNoEntry : activityNoList) {
			sql = "select * from goods_t where goodsId=?";
			List<GoodsEntry> goodsList = query(sql, GoodsEntry.class,
					activityNoEntry.getProId());
			if (goodsList.size() == 0) {
				continue;
			}
			proList.add(goodsList.get(0));
		}
		activityEntry.setProList(proList);
		return activityEntry;
	}

}

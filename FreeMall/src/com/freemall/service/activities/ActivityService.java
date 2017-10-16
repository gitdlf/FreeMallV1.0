package com.freemall.service.activities;

import com.freemall.dao.IActivityDao;
import com.freemall.dao.entry.ActivityEntry;
import com.freemall.dao.imp.ActivityDao;

public class ActivityService implements IActivityDao {

	public ActivityEntry getActivity(String activityNo) {
		
		return new ActivityDao().getActivity(activityNo);
	}

}

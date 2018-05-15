package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.repository.Activity;
import com.revature.repository.User;

public class ActivityImplementation implements ActivityDao{

	@Override
	public Activity findActivity(int activityId) {
		Activity swim = new Activity();
		swim.setActivityId(10);
		swim.setActivityName("Swimming");
		swim.setDuration("40");
		
		User athelete = new User();
		athelete.setAge(20);
		athelete.setName("Alex");
		swim.setUser(athelete);
		return swim;
	}

	@Override
	public List<Activity> GetAllActivities() {
		Activity swim = new Activity();
		swim.setActivityId(10);
		swim.setActivityName("Swimming");
		swim.setDuration("40");
		Activity bike = new Activity();
		bike.setActivityId(20);
		bike.setActivityName("Biking");
		bike.setDuration("60");
		
		List<Activity> list = new ArrayList<>();
		list.add(bike);
		list.add(swim);
		//System.out.println(list);
		return list;
	}
	
}

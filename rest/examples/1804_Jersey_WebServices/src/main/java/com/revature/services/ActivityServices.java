package com.revature.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.dao.ActivityDao;
import com.revature.dao.ActivityImplementation;
import com.revature.repository.Activity;
import com.revature.repository.User;

@Path("activities")
public class ActivityServices {

	ActivityDao ai = new ActivityImplementation();
	
	@GET
	@Path("{activityid}")		//http://dns:port/projectname/webapi/activities/activityid
	@Produces(MediaType.APPLICATION_XML)
	public Activity getActivity(@PathParam("activityid") int activityId){
		return ai.findActivity(activityId);
	}
	
	@GET			//http://dns:port/projectname/webapi/activities
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return ai.GetAllActivities();
	}
	
	@GET			//http://dns:port/projectname/webapi/activities/activityid/user
	@Path("{activityid}/user")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User getUser(@PathParam("activityid") int activityId){
		return ai.findActivity(activityId).getUser();
	}
	
}

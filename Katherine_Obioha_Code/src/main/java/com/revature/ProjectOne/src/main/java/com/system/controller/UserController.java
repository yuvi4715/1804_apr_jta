package com.system.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.system.model.Request;
import com.system.model.User;
import com.system.service.RequestService;
import com.system.service.UserService;

public class UserController {

	final static Logger logger = Logger.getLogger(UserController.class);
	UserService userservice = new UserService();
	
	static RequestController reqcontroller = new RequestController();
	static User user = new User();

	// both employee and manager can login
	public static JSONArray login(String username, String password, String role, String status) {
		
		user = UserService.getUser(username, role, 0);
		//System.out.println(user.toString());
	if (user.getPassword().equalsIgnoreCase(password)) 
		{ logger.info("user succesfully logged in");
			if(user.getRole().equalsIgnoreCase("employee"))
				{ 
					
					logger.info("user is an employee");
					if ((status.equalsIgnoreCase("null")) || (status.equalsIgnoreCase("all")))
					{
					List<Request> n = UserController.usergetrequests(user);
					System.out.println(n.toString());
					JSONArray ray = new JSONArray();
					JSONObject	person= new JSONObject(user);
					ray.put(person);
					ray.put(n);
					
					return ray;
					}
					else
					{
						
						List<Request> n = RequestService.getsortedrequest(status);
						JSONArray ray = new JSONArray();
						JSONObject	person= new JSONObject(user);
						ray.put(person);
						ray.put(n);
						
						return ray;
					}
				}
			else{	logger.info("user is a manager");
					List<Request>n = UserController.getallrequest();
					JSONArray ra = new JSONArray();
					JSONObject person = new JSONObject(user);
					ra.put(person);
					ra.put(n);
					return ra;
				}
			}
	else
		{
			return null;
		}
	
}

	// both employee and manager have portals
	public boolean userhomepagedata() {
		// already initialized through login so data is available
		return false;
	}

	// only an employee can create request
	public static JSONArray createrequest(Request request, int id) {
		boolean n = reqcontroller.createrequest(id, request); 
		JSONArray narray = new JSONArray();
		narray.put(n);
		return narray;
		
	}
	
	//both employee and user can update their information
	public boolean updateUser(User user)
	{
		userservice.updateUser(user);
		return false;	
	}
	
	public static List<Request>getallrequest()
	{
		return  reqcontroller.getAllRequests();
	}

	/**
	 * Both an employee and Manager can return a List of requests
	 * 
	 * @category Employee - an employee can return or view all requests
	 *           belonging to him. He can also filter it by status (Pending or
	 *           resolved
	 * 
	 * @category Manager - A manager can return or view all request also by
	 *           status. Pending status request by Employee and Resolved Status
	 *           by manager who resolved it and employee who requested it
	 */
	
	public static List <Request> usergetrequests(User user)
	{
		return reqcontroller.getRequest(user);
		
	}
	
	public static JSONArray updateRequest(int requestid, String status, int userid)
	{
		boolean n =reqcontroller.updateRequest(requestid, status, userid);
		JSONArray narray = new JSONArray();
		narray.put(n);
		return narray;
		
	}
	
//	public static void main(String[]args)
//	{
//		User u = new User();
//		JSONArray y = UserController.login("katty", "pass");
//		
//		//getting objects
////		JSONObject t = y.getJSONObject(0);
////		System.out.println(t.get("role"));
//		
//		//getting the arrays (requests)
////		JSONArray b = y.getJSONArray(1); //getting the array at the 1st index
////		JSONObject c = b.getJSONObject(0); //getting the object inside the array
////		JSONObject d = c.getJSONObject("requester");
////		System.out.println(b); 
////		System.out.println(c);
////		System.out.println(c.get("reviewdate")); //get an element inside the object inside an array inside an array
////		System.out.println(c.get("requester")); //get all elements inside a named array object
////		System.out.println(d.get("username")); //get an element inside an object inside an array
//	
//	}

}

package com.system.controller;

import java.util.List;



import com.system.model.User;

import com.system.model.Request;
import com.system.service.RequestService;

public class RequestController {

	RequestService reqservice = new RequestService();
	
	//only an employee can create a request
	public boolean createrequest(int id, Request request) {
		// TODO Auto-generated method stub
		
		return reqservice.createrequest(request, id);
	}
	public List<Request> getRequest(User user)
	{
		return reqservice.getrequest(user);
	}

	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return reqservice.getallrequest();
		
	}

	public boolean updateRequest(int request, String status, int userid) {
		// TODO Auto-generated method stub
		return reqservice.updateRequest(request, status, userid);
	}
	
	

}

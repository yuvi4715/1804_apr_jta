package com.system.service;

import java.sql.SQLException;
import java.util.List;

import com.system.dao.RequestInterface;
import com.system.model.Request;
import com.system.model.User;
import com.system.dao.RequestImpl;

public class RequestService {

	private static RequestInterface dao = RequestImpl.getInstance();
	
	public boolean createrequest(Request request, int id) {
		// TODO Auto-generated method stub
		try {
			return dao.createrequest(request, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Request> getrequest(User user) {
		// TODO Auto-generated method stub
		return dao.getrequest(user);
	}

	public List<Request> getallrequest() {
		// TODO Auto-generated method stub
		return dao.getallrequest();
	}

	public boolean updateRequest(int request, String status, int userid) {
		// TODO Auto-generated method stub
		return dao.updateRequest(request, status, userid);
	}
	public static List<Request>getsortedrequest(String status)
	{
		return dao.getsortedrequest(status);
	}

	public boolean deleteRequest() {
		// TODO Auto-generated method stub
		return dao.deleteRequest();
	}

}

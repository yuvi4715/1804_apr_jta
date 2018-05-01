package com.system.dao;

import java.sql.SQLException;
import java.util.List;

import com.system.model.Request;
import com.system.model.User;

public interface RequestInterface {

	public boolean createrequest(Request request, int id) throws SQLException;
	public List<Request> getrequest(User user);
	public List<Request> getallrequest();
	public boolean updateRequest(int request, String status, int userid);
	public List<Request>getsortedrequest(String y);
	public boolean deleteRequest();
}

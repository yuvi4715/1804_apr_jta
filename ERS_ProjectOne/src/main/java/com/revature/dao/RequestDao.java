package com.revature.dao;

import java.util.List;

import com.revature.model.Request;


public interface RequestDao {
	public boolean insertRequest(Request inputRequest);
	public boolean approveRequest(int inputID, String username);
	public boolean denyRequest(int inputID, String username);
	public List<Request> getAllPendingRequest(String employeeUser);
	public List<Request> getAllResolvedRequest(String employeeUser);
	public List<Request> getAllRequest(String employeeUser);
	public List<Request> getAllPendingRequest();
	public List<Request> getAllResolvedRequest();
}

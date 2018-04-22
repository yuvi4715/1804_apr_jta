package com.ranieri.dao;

import java.util.List;

import com.ranieri.model.Request;

public interface RequestDao {
	
	public List<Request> getAllRequest();
	public boolean createRequest(String email, String reason, double amount, String image);
	public boolean updateRequest(int requestID, String status, String manager);
	

}

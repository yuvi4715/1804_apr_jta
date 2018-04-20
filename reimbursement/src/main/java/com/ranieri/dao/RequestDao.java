package com.ranieri.dao;

import java.util.List;

import com.ranieri.request.*;

public interface RequestDao {
	
	public Request getRequest();
	public List<Request> getAllRequest();
	public Request createRequest();
	public Request updateRequest();
	

}

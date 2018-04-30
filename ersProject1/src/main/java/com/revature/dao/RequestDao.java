package com.revature.dao;

import java.util.List;

import com.revature.beans.Request;

public interface RequestDao {
	public boolean insertIntoRequest(Request request);
	public boolean updateReviewed(int requestId,String statusOfRequest,int reviewedBy);
	public boolean updateStatusOfRequest(int requestId, String status);
	public List<Request> getRequestsByRequesterUsername(String username);
	public List<Request> getRequestsByReviewerUsername(String username);
	public List<Request> getAllRequests();
	public List<Request> getAllPendingRequests();
	public List<Request> getAllApprovedRequests();
	public List<Request> getAllDeniedRequests();
	public boolean updateRequest(Request request);
	
	
}
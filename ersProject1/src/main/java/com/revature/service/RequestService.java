package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Request;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;

public class RequestService {
	private static RequestDao dao = RequestDaoImpl.getInstance();
	private static Logger log = Logger.getLogger(RequestService.class);
	
	public static boolean insertIntoRequest(Request request) {
		boolean pass = dao.insertIntoRequest(request);
		if (pass) log.info("A request was successfully inserted into the request table");
		else log.info("A request failed to be inserted into the request table");
		return pass;
	}
	
	public static boolean updateReviewed(int requestId,String statusOfRequest,int reviewedBy) {
				boolean pass = dao.updateReviewed(requestId, statusOfRequest, reviewedBy);
				if (pass) log.info("Request has been reviewed");
				else log.info("Request failed to be reviewed");
				return pass;
	}
	
	public static boolean updateStatusOfRequest(int requestId, String status) {
		boolean pass = dao.updateStatusOfRequest(requestId, status);
		if(pass) log.info("Status has been updated");
		else log.info("Status failed to update");
		return pass;
	}
	
	public static List<Request> getRequestsByRequesterUsername(String username) {
		return dao.getRequestsByRequesterUsername(username);
	}
	
	public static List<Request> getAllRequests() {
		return dao.getAllRequests();
	}
	
	public static List<Request> getAllPendingRequests() {
		return dao.getAllPendingRequests();
	}
	
	public static List<Request> getAllApprovedRequests() {
		return dao.getAllApprovedRequests();
	}
	
	public static List<Request> getAllDeniedRequests() {
		return dao.getAllDeniedRequests();		
	}
	
	public static boolean updateRequest(Request request) {
		boolean pass = dao.updateRequest(request);
		if (pass) log.info("A request has had all fields updated");
		else log.info("A request failed to have all fields updated");
		return pass;
	}
	
	public static List<Request> getRequestsByReviewerUsername(String username) {
		return dao.getRequestsByReviewerUsername(username);
	}

}

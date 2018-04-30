package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoJdbc;
import com.revature.model.Request;

public class RequestService {
	private static RequestDao dao = new RequestDaoJdbc();

	public static boolean insertRequest(Request inputRequest) {
		return dao.insertRequest(inputRequest);
	}

	public static List<Request> getAllRequest(String employeeUser) {
		return dao.getAllRequest(employeeUser);
	}
	public static List<Request> getAllPendingRequest() {
		return dao.getAllPendingRequest();
	}
	public static List<Request> getAllResolvedRequest() {
		return dao.getAllResolvedRequest();
	}

	public static boolean approveRequest(int requestID, String username) {
		return dao.approveRequest(requestID, username);
	}
	
	public static boolean denyRequest(int requestID, String username) {
		return dao.denyRequest(requestID, username);
	}
	
	public static List<Request> getAllPendingRequest(String employeeUser) {
		return dao.getAllPendingRequest();
	}
	public static List<Request> getAllResolvedRequest(String employeeUser) {
		return dao.getAllResolvedRequest();
	}
}

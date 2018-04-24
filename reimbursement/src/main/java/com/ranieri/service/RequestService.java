package com.ranieri.service;

import java.util.List;

import com.ranieri.dao.RequestDao;
import com.ranieri.dao.RequestDaoImpl;
import com.ranieri.model.Request;

public class RequestService {

	
public static RequestDao dao = RequestDaoImpl.getInstance();
	
	private RequestService() {};
	
	
	public static List<Request> getAllRequests(){
		return dao.getAllRequest();
	}
	
	public static boolean createRequest(String email, String reason, double amount, String image) {
		return dao.createRequest(email, reason, amount, image);
	}
	
	public static boolean updateRequest(int requestID, String status, String manager) {
		
		return dao.updateRequest(requestID, status, manager);
	}
	
	
	public static void main(String[] args) {
		
//	List<Request> test = dao.getAllRequest();	
//	test.forEach(System.out::println);
		
//		dao.createRequest("tester@test.com", "hibachi dinner", 1900, "image29");
//		dao.updateRequest(8, "denied", "evil boss");

	}

}

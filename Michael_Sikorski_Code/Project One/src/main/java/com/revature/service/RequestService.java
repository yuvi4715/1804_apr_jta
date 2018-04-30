/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDAOImplement;
import com.revature.model.Request;

public class RequestService {

	private static RequestService requestService;

	private RequestService() {
	}
	
	public static RequestService getRequestService() {
		if (requestService == null) {
			requestService = new RequestService();
		}
		return requestService;
	}
	
	public boolean submitRequest(String requester, double amount, String purpose) {
		return RequestDAOImplement.getInstance().createNewRequest(requester, amount, purpose);
	}
	
	public Request getRequestById(int requestId) {
		return RequestDAOImplement.getInstance().getRequestById(requestId);
	}
	
	public List<Request> getAllResolvedRequests() {
		return RequestDAOImplement.getInstance().getAllResolvedRequests();
	}
	
	public List<Request> getAllPendingRequests() {
		return RequestDAOImplement.getInstance().getAllPendingRequests();
	}
	
	public List<Request> getEmployeesPendingRequests(String email) {
		return RequestDAOImplement.getInstance().getEmployeesPendingRequests(email);
	}
	
	public List<Request> getEmployeesResolvedRequests(String email) {
		return RequestDAOImplement.getInstance().getEmployeesResolvedRequests(email);
	}
	
	public boolean resolveRequest(int requestId, String newStatus, String manager) {
		return RequestDAOImplement.getInstance().resolveRequest(requestId, newStatus, manager);
	}
	
}

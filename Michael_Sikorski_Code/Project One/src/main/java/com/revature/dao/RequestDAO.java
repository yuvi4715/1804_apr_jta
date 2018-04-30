/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import java.util.List;

import com.revature.model.Request;

/**
 * The RequestDAO interface defines the standard operations that will be
 * performed on the Request model object
 */
public interface RequestDAO {
	boolean createNewRequest(String requester, double amount, String purpose);
	Request getRequestById(int requestId);
	List<Request> getAllRequestsBySingleEmployee(String email);
	List<Request> getEmployeesResolvedRequests(String email);
	List<Request> getEmployeesPendingRequests(String email);
	List<Request> getAllRequests();
	List<Request> getAllResolvedRequests();
	List<Request> getAllPendingRequests();
	boolean resolveRequest(int requestId, String newStatus, String manager);
	boolean deleteRequest(int requestId);
}

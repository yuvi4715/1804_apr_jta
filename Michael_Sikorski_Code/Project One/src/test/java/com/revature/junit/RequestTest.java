/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.junit;

import java.text.NumberFormat;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import com.revature.model.*;
import com.revature.service.*;

// Test class for Request objects
public class RequestTest {

	NumberFormat nf = NumberFormat.getInstance();

	@Test
	public void ReimbursementRequestIsSuccessful() {
		double amount = Math.random() * 100;
		boolean success = RequestService.getRequestService().submitRequest("testEmployee", amount,
				"Testing request submission method");
		Assert.assertEquals(true, success);
	}

	@Test
	public void validateRequestInformation() {
		Request test = RequestService.getRequestService().getRequestById(1);
		Assert.assertEquals(1, test.getRequestID());
		Assert.assertEquals(1, test.getRequestAmount(), 0);
		Assert.assertEquals("testEmployee", test.getRequester());
		Assert.assertEquals("Pending Approval", test.getStatus());
		Assert.assertEquals("Testing validate request information method", test.getPurpose());
	}

	@Test
	public void validateRequestApproval() {
		RequestService.getRequestService().resolveRequest(2, "approved?", "testManager"); // simulate a Manager
																							// approving the request
		Request r2 = RequestService.getRequestService().getRequestById(2);
		Assert.assertEquals("approved?", r2.getStatus());
		Assert.assertEquals("testManager", r2.getReviewer());
		RequestService.getRequestService().resolveRequest(2, "Pending Approval", "testManager2");
		Request r3 = RequestService.getRequestService().getRequestById(2);
		Assert.assertEquals("Pending Approval", r3.getStatus());
		Assert.assertEquals("testManager2", r3.getReviewer());
	}
	
	@Test
	public void validateRequestDenial() {
		RequestService.getRequestService().resolveRequest(4, "denied?", "testManager"); // simulate a Manager
																							// denying the request
		Request r2 = RequestService.getRequestService().getRequestById(4);
		Assert.assertEquals("denied?", r2.getStatus());
		Assert.assertEquals("testManager", r2.getReviewer());
		RequestService.getRequestService().resolveRequest(4, "Pending Approval", "testManager2");
		Request r3 = RequestService.getRequestService().getRequestById(4);
		Assert.assertEquals("Pending Approval", r3.getStatus());
		Assert.assertEquals("testManager2", r3.getReviewer());
	}

	@Test
	public void validateResolvedRequestsAreResolved() {
		List<Request> supposedlyResolvedRequests = RequestService.getRequestService().getAllResolvedRequests();
		for (Request r : supposedlyResolvedRequests) {
			Assert.assertNotEquals("Pending Approval", r.getStatus());
		}
	}
	
	@Test
	public void validatePendingRequestsArePending() {
		List<Request> supposedlyPending = RequestService.getRequestService().getAllPendingRequests();
		for (Request r : supposedlyPending) {
			Assert.assertEquals("Pending Approval", r.getStatus());
		}
	}

	@Test
	public void validateSingleEmployeesRequestReturnsCorrectInformation() {
		Employee e = new Employee("singleEmployee", "singleEmployee", "singleFirst", "singleLast");
		Request r1 = RequestService.getRequestService().getEmployeesPendingRequests(e.getEmail()).get(0);
		Assert.assertEquals(r1.getStatus(), "Pending Approval");
		Assert.assertEquals(r1.getPurpose(), "test get single employee requests");
		Assert.assertEquals(r1.getRequestAmount(), 55, 0);
	}
}

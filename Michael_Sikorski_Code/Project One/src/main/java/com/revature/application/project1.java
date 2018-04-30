/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.application;

import com.revature.model.*;
import com.revature.service.EmployeeService;
import com.revature.service.RequestService;
import com.revature.util.LogUtil;

// Tester class for Project One
public class project1 {

	public static void main(String[] args) {
		LogUtil.logger.info("TEST");
		for (Employee e : EmployeeService.getEmployeeService().getAllEmployees()) {
			for (Request r : RequestService.getRequestService().getEmployeesPendingRequests(e.getEmail())) {
				System.out.println(r.toString());
			}
		}
		for (Request r : RequestService.getRequestService().getAllPendingRequests()) {
			System.out.println(r.toString());
		}
		
		for (Employee e : EmployeeService.getEmployeeService().getAllEmployees()) {
			System.out.println("Employee Info: ");
			System.out.println(e.toString());
			System.out.println();
			System.out.println("Pending: ");
			for (Request r : RequestService.getRequestService().getEmployeesPendingRequests(e.getEmail())) {
				System.out.println(r.toString());
			}
			System.out.println();
			System.out.println("Resolved: ");
			for (Request r : RequestService.getRequestService().getEmployeesResolvedRequests(e.getEmail())) {
				System.out.println(r.toString());
			}
		}
	}
}

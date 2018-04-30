/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import java.util.List;

import com.revature.model.*;

/**
 * The EmployeeDAO interface defines the standard operations that will be
 * performed on the Employee model object
 */
public interface EmployeeDAO {

	boolean createNewEmployee(String email, String username, String password, String first, String last);
	Employee getEmployee(String email);
	List<Employee> getAllEmployees();
	boolean updateEmployee(String email, String newUsername, String newFirst, String newLast);

}

/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.dao;

import com.revature.model.*;

/**
 * The ManagerDAO interface defines the standard operations that will be
 * performed on the Manager model object
 */
public interface ManagerDAO {
	
	boolean createNewManager(String email, String username, String password, String first, String last);
	Manager getManager(String email);

}

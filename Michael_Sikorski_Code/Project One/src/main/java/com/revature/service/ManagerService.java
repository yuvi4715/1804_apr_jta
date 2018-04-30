/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.service;

import com.revature.dao.*;
import com.revature.model.*;

public class ManagerService {

	private static ManagerService managerService;

	private ManagerService() {
	}
	
	public static ManagerService getManagerService() {
		if (managerService == null) {
			managerService = new ManagerService();
		}
		return managerService;
	}
	
	public boolean createNewManager(String email, String username, String password, String first, String last) {
		return ManagerDAOImplement.getInstance().createNewManager(email, username, password, first, last);
	}
	
	public Manager getManager(String email) {
		return ManagerDAOImplement.getInstance().getManager(email);
	}
	
}

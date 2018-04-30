package com.revature.service;

import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoJdbc;
import com.revature.model.Manager;

public class ManagerService {
	private static ManagerDao dao = new ManagerDaoJdbc();

	public static Manager getManager(String username, String password) {
		return dao.getManager(username, password);
	}
}

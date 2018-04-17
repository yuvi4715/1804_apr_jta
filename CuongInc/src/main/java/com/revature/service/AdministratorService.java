package com.revature.service;

import com.revature.dao.AdminDaoImpl;
import com.revature.dao.AdministratorDao;
import com.revature.model.Administrator;

public class AdministratorService {

	private static AdministratorDao dao = new AdminDaoImpl();

	public static boolean insertAdmin(Administrator inputAdmin) {
		return dao.insertAdmin(inputAdmin);
	}

	public static Administrator getAdmin(String testUsername) {
		return dao.getAdmin(testUsername);
	}

	public static boolean updateAdmin(Administrator inputAdmin) {
		return dao.updateAdmin(inputAdmin);
	}

	public static boolean deleteAdmin(String username) {
		return dao.deleteAdmin(username);
	}
}

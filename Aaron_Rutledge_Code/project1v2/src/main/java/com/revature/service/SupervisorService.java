package com.revature.service;

import com.revature.model.Supervisor;
import com.revature.model.Employee;
import com.revature.dao.TemplateDao;
import com.revature.dao.SupervisorDao;
import java.util.List;

public class SupervisorService {

	private static TemplateDao<Employee, Integer> dao = new SupervisorDao();
	
	private SupervisorService() {}
	
	public static Employee login(String email, String pass) {
		return dao.login(email, pass);
	}
}



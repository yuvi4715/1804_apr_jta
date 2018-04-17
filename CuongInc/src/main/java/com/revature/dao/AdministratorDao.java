package com.revature.dao;

import com.revature.model.Administrator;

public interface AdministratorDao {
	public boolean insertAdmin(Administrator inputAdmin);
	public Administrator getAdmin(String username);
	public boolean updateAdmin(Administrator inputAdmin);
	public boolean deleteAdmin(String username);

}

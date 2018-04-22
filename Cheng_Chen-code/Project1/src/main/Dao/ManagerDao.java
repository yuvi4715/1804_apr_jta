package main.Dao;

import main.Model.Manager;

public interface ManagerDao 
{
	public boolean insertManager(Manager e);
	public Manager getManager(String email);
	public boolean updateManager(Manager e);
}

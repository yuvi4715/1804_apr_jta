package main.Service;

import java.util.List;

import main.Dao.DaoImpl;
import main.Model.Employee;
import main.Model.Manager;
import main.Model.Reimbursement;

public class ReimbursementService 
{
	private static DaoImpl dao = new DaoImpl();
	
	public static boolean insertReimbursement(Reimbursement r)
	{
		return dao.insertReimbursement(r);
	}
	
	public static Reimbursement getReimbursement(int id)
	{
		return dao.getReimbursement(id);
	}
	
	public static boolean updateReimbursement(Reimbursement r)
	{
		return dao.updateReimbursement(r);
	}
	
	public List<Reimbursement> getAllReimbursements()
	{
		return dao.getAllReimbursements();
	}
	
	public List<Reimbursement> getAllPending()
	{
		return dao.getAllPending();
	}
	
	public List<Reimbursement> getAllResolved()
	{
		return dao.getAllResolved();
	}
	
	public List<Reimbursement> getAllPendingForE(Employee e)
	{
		return dao.getAllPendingForE(e);
	}
	
	public List<Reimbursement> getAllResolvedForE(Employee e)
	{
		return dao.getAllResolvedForE(e);
	}
	
	public boolean insertManager(Manager m)
	{
		return dao.insertManager(m);
	}
	
	public Manager getManager(String email)
	{
		return dao.getManager(email);
	}
	
	public boolean updateManager(Manager m)
	{
		return dao.updateManager(m);
	}
	
	public boolean insertEmployee(Employee e)
	{
		return dao.insertEmployee(e);
	}
	
	public Employee getEmployee(String email)
	{
		return dao.getEmployee(email);
	}
	
	public boolean updateEmployee(Employee e)
	{
		return dao.updateEmployee(e);
	}
	
	public List<Employee> getAllEmployees()
	{
		return dao.getAllEmployees();
	}
}

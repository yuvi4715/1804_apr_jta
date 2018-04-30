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
	
	public static List<Reimbursement> getAllReimbursements()
	{
		return dao.getAllReimbursements();
	}
	
	public static List<Reimbursement> getAllPending()
	{
		return dao.getAllPending();
	}
	
	public static List<Reimbursement> getAllResolved()
	{
		return dao.getAllResolved();
	}
	
	public static List<Reimbursement> getAllForE(Employee e)
	{
		return dao.getAllForE(e);
	}
	
	public static List<Reimbursement> getAllPendingForE(Employee e)
	{
		return dao.getAllPendingForE(e);
	}
	
	public static List<Reimbursement> getAllResolvedForE(Employee e)
	{
		return dao.getAllResolvedForE(e);
	}
	
	public static boolean insertManager(Manager m)
	{
		return dao.insertManager(m);
	}
	
	public static Manager getManager(String email)
	{
		return dao.getManager(email);
	}
	
	public static boolean updateManager(Manager m)
	{
		return dao.updateManager(m);
	}
	
	public static boolean insertEmployee(Employee e)
	{
		return dao.insertEmployee(e);
	}
	
	public static Employee getEmployee(String email)
	{
		return dao.getEmployee(email);
	}
	
	public static boolean updateEmployee(Employee e)
	{
		return dao.updateEmployee(e);
	}
	
	public static List<Employee> getAllEmployees()
	{
		return dao.getAllEmployees();
	}
}

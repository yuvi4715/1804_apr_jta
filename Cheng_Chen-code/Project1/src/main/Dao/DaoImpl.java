package main.Dao;

import java.util.List;

import main.Model.Employee;
import main.Model.Manager;
import main.Model.Reimbursement;

public class DaoImpl implements EmployeeDao, ManagerDao, ReimbursementDao
{
	
	private static DaoImpl instance;
	
	public static DaoImpl getInstance()
	{
		if(instance == null)
		{
			instance = new DaoImpl();
		}
		return instance;
	}

	//REIMBURSEMENT DAO STUFF
	@Override
	public boolean insertReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursement getReimbursement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllPendingForE(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllResolvedForE(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//MANAGER DAO STUFF

	@Override
	public boolean insertManager(Manager m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Manager getManager(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateManager(Manager m) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//EMPLOYEE DAO STUFF

	@Override
	public boolean insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployee(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}

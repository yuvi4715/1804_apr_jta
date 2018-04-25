package main.Dao;

import java.util.List;

import main.Model.Employee;
import main.Model.Reimbursement;

public interface ReimbursementDao 
{
	public boolean insertReimbursement(Reimbursement r);
	public Reimbursement getReimbursement(int id);
	public boolean updateReimbursement(Reimbursement r);
	public List<Reimbursement> getAllReimbursements();
	public List<Reimbursement> getAllPending();
	public List<Reimbursement> getAllResolved();
	public List<Reimbursement> getAllPendingForE(Employee e);
	public List<Reimbursement> getAllResolvedForE(Employee e);
}


package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursment;



public interface ReimbursmentDAO 
{
	public boolean insertRecord(Reimbursment rec);	// Create
	public Reimbursment getRecord(int id);
	public List<Reimbursment>  getAllMyPending(String username);	// Read
	public List<Reimbursment>  getAllMyApproved(String username);	// Read
	public List<Reimbursment> getAllEmployeeRecords(String username);		// Read
	public List<Reimbursment>  getAllPending();	// Read
	public List<Reimbursment> getAllRecords();		// Read
	public boolean updateStatus(Reimbursment rec, String manager, String Status);	// Update
}

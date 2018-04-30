package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbursmentDAO;
import com.revature.dao.ReimbursmentDAOImpl;
import com.revature.model.Reimbursment;

public class ReimbursmentService
{
	
	public static ReimbursmentDAO dao = new ReimbursmentDAOImpl();
	
	public static boolean insertRecord(Reimbursment rec)
	{
		return dao.insertRecord(rec);
	}
	public static Reimbursment getRecord(int id)
	{
		return dao.getRecord(id);
	}
	
	public static List<Reimbursment>  getAllMyPending(String username)
	{
		return dao.getAllMyPending(username);
	}
	
	public static List<Reimbursment>  getAllMyApproved(String username)
	{
		return dao.getAllMyApproved(username);
	}
	
	public static List<Reimbursment> getAllEmployeeRecords(String username)
	{
		return dao.getAllEmployeeRecords(username);
	}
	
	public static List<Reimbursment>  getAllPending()
	{
		return dao.getAllPending();
	}
	
	public static List<Reimbursment> getAllRecords()
	{
		return dao.getAllRecords();
	}
	
	public static boolean updateStatus(Reimbursment rec, String manager, String status)
	{
		return dao.updateStatus(rec, manager, status);
	}
	
}

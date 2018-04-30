package com.revature.dao;

import java.util.List;

import com.revature.models.Request;
import com.revature.models.User;

public interface Reimbursement_Dao {
	public boolean addUser(String fname, String lname, String email, String pw);
	public boolean addAdmin(String fname, String lname, String email, String pw);
	public boolean addRequest(double amount, int id, String purpose);
	public boolean changeUserName(int id, String fname, String lname);
	public boolean changeUserPassword(int id, String pw);
	public boolean changeAdminName(int id, String fname, String lname);
	public boolean changeAdminPassword(int id, String pw);
	public boolean resolve(String status, String comment, int adminId, int requestId);
	public List<User> getAllUsers();
	public List<User> getAllAdmins();
	public List<Request> getAllRequests();
	public List<Request> getMyResolvedRequests(int id);
	public List<Request> getMyPendingRequests(int id);
	public List<Request> getPendingRequests();
	public List<Request> getResolvedRequests();
	public List<Request> getRequestsByUser(int id);
	public User userLogin(String un, String pw);
	public User adminLogin(String un, String pw);
}

package com.revature.service;


import java.util.List;



import com.revature.DAO.*;

import com.revature.model.Request;
import com.revature.model.User;
public class UserService {
	private static UserDAO dao = UserDAOImpl.getInstance();
	
	public static boolean logOn(String username, String password) {
		return dao.logOn(username, password);
	}
	
	public static User getUser(String username, String password) {
		return dao.getUser(username, password);
	}
	
	public static boolean isManager(String email) {
		return dao.isManager(email);
	}
	
	public static boolean updateUser(String email, String firstname, String lastname, String password) {
		return dao.updateUser(email, firstname, lastname, password);
	}
	
	public static List<User> getAllUsers(){
		return dao.getAllUsers();
	}
	
	public static List<Request> getEmployeeRequests(String email) {
		return dao.getEmployeeRequests(email);
	}
	
	public static List<Request> getResolvedRequests(String email) {
		return dao.getResolvedRequests(email);
	}
	
	public static List<Request> getPendingRequests(String email) {
		return dao.getPendingRequests(email);
	}
	
	public static List<Request> getAllRequests() {
		return dao.getAllRequests();
	}
	
	public static List<Request> getAllResolvedRequests()  {
		return dao.getAllResolvedRequests();
	}
	
	public static List<Request> getAllPendingRequests()  {
		return dao.getAllPendingRequests();
	}
	
	public static boolean submitRequest(String email, int amount, String purpose) {
		return dao.submitRequest(email, amount, purpose);
	}
	
	public static boolean checkUsername(String username) {
		return dao.checkUsername(username);
	}
	
	public static boolean respondToRequest(String email,int amount, String requester, String response) {
		return dao.respondToRequest(email, amount, requester, response);
	}
}

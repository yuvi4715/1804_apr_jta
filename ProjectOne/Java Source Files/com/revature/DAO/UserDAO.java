package com.revature.DAO;

import java.util.List;

import com.revature.model.Request;
import com.revature.model.User;



public interface UserDAO {
	public boolean logOn(String username, String password); //done
	public boolean checkUsername(String username); // done
	public boolean submitRequest(String email, int amount, String purpose); // done
	public boolean updateUser(String email, String firstname,String lastname, String Password); //done
	public boolean isManager(String email); // done?
	public boolean respondToRequest(String email,int amount, String requester, String response);
	
	
	public User getUser(String username, String password); // done
	public List<User> getAllUsers(); // manager only done
	public List<Request> getAllRequests();	// manager only done
	public List<Request> getPendingRequests(String email); // done
	public List<Request> getResolvedRequests(String email); // done
	public List<Request> getAllResolvedRequests(); // manager only done
	public List<Request> getAllPendingRequests(); // manager only done
	public List<Request> getEmployeeRequests(String email);	// manager only done

	
}

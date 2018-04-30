package employee;

import java.util.List;

import manager.Manager;
import request.Request;

/**
 * DAO Interface for Employee Bean
 * @author joeyi
 *
 */
public interface EmployeeDAO {
	boolean login(String username, String password); //login
	boolean logout(); //logout
	int getId(String username);
	Employee getEmployee(int eid); //get info about employee
	Employee updateEmployee(int eid,  String username, String password); //update employee info, true if updated
	
	List<Request> getPendingRequests(int eid); //view all pending requests by employee
	List<Request> getResolvedRequests(int eid); //view all resolved requests by employee
	
	boolean submitRequest(float amount, String purpose, int eid); //submit new requests
	void uploadImg(int rid); //upload receipt for request
	Request getRequest(int rid);

}

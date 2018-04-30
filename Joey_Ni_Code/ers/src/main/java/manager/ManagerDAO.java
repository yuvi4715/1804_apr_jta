package manager;

import java.util.List;

import employee.Employee;
import request.Request;

/**
 * The DAO interface for Manager Bean Class
 * @author joeyi
 *
 */
public interface ManagerDAO {
	boolean login(String username, String password); //login
	boolean logout(); //logout
	Manager getManager(int mid); //get info about manager, view manager homepage
	int getId(String username);
	Manager updateManager(int mid, String username, String password); //update manager info
	
	List<Request> getAllPendingRequests(); //view all pending requests from all employees
	List<Request> getAllResolvedRequests(); //get all resolved requests with manager info
	
	boolean approveRequest(int rid,int mid, int ap); //true if approved, false if denied
	void getImg(int rid); //view receipt img depending on request
	List<Employee> getAllEmployees(); //view all employee info
	List<Request> getEmployeeRequests(int eid);  //view reimbursement requests depending on employee id
	Request getRequest(int rid);
	boolean insertEmployee(String username, String password, String lastname, String firstname);
	boolean insertManager(String username, String password, String lastname, String firstname);
	boolean createEmployeeLogin(String username, String password, int eid);
	Employee getEmployee(int eid);
	boolean deleteEmployee(int eid);
	void createUser(String username, String password);
	boolean deleteUser(String username);
	void grantEmployee(String username);

}

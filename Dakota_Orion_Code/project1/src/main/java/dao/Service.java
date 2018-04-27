package dao;

import java.util.List;

public class Service {
	private static EmployeeDao dao1 = RequestEmployeeDaoImpl.getInstance();
	private static RequestDao dao2 = RequestEmployeeDaoImpl.getInstance();
	public static boolean insertRequest(Request req) {
		return dao2.insertRequest(req);
	}

	public static Request getRequest(int id) {
		return dao2.getRequest(id);
	}
	
	public static List<Request> getResolvedRequests(){
		return dao2.getResolvedRequests();
	}
	
	public static List<Request> getUnresolvedRequests(){
		return dao2.getUnresolvedRequests();
	}

	public static List<Request> getAllRequests() {
		return dao2.getAllRequests();
	}

	public static boolean updateRequest(Request req) {
		return dao2.updateRequest(req);
	}

	public static boolean insertEmployee(Employee Employee) {
		return dao1.insertEmployee(Employee);
	}

	public static Employee getEmployeeByID(int id) {
		return dao1.getEmployeeByID(id);
	}
	
	public static Employee getEmployeeByUsername(String str) {
		return dao1.getEmployeeByUsername(str);
	}
	
	public static Employee getEmployeeByEmail(String str) {
		return dao1.getEmployeeByEmail(str);
	}

	public static List<Employee> getAllEmployees() {
		return dao1.getAllEmployees();
	}

	public static boolean updateEmployee(Employee Employee) {
		return dao1.updateEmployee(Employee);
	}

	public static boolean deleteEmployeeByID(int a) {
		return dao1.deleteEmployeeByID(a);
	}
	
	public static boolean deleteEmployeeByUsername(String str) {
		return dao1.deleteEmployeeByUsername(str);
	}

	public static boolean deleteEmployeeByEmail(String str) {
		return dao1.deleteEmployeeByEmail(str);
	}
}

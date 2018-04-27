package dao;

import java.util.List;

public interface EmployeeDao {
	public boolean insertEmployee(Employee Employee);
	public Employee getEmployeeByID(int id);
	public Employee getEmployeeByUsername(String str);
	public Employee getEmployeeByEmail(String str);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee Employee);
	public boolean deleteEmployeeByID(int a);
	public boolean deleteEmployeeByEmail(String str);
	public boolean deleteEmployeeByUsername(String str);
}

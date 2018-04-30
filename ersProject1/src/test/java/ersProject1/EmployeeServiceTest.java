package ersProject1;

import java.util.List;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import com.revature.beans.Employee;
import com.revature.service.EmployeeService;
import junit.framework.TestCase;

public class EmployeeServiceTest extends TestCase {
	
	@Ignore
	@Test
	public void insertTest() {
		String username = "Tristan";
		assertTrue(EmployeeService.insertEmployee(new Employee(0,"yugioh.com",username,"t","Testin","Testman",true,true)));
	}
	
	@Test
	public void getEmployeeTest() {
		String username = "Tester";
		Employee e = EmployeeService.getEmployee(username);
		assertNotNull(e);
	}
	
	@Test
	public void getPasswordTest() {
		String username="Tester";
		String password = EmployeeService.getEmployeePassword(username);
		assertNotNull(password);
	}
	
	@Test
	public void getAllEmployeeTest() {
		List<Employee> le = EmployeeService.getAllEmployees();
		assertNotNull(le);
	}
	
	@Test
	public void updateEmploymentStatusTest() {
		boolean status = true;
		String username = "Tester";
		assertTrue(EmployeeService.updateEmploymentStatus(username, status));
	}
	
	@Test
	public void updateEmployeeTest() {
		Employee employee = new Employee(2,"test@test.com","Tester","Test","Test","Testman",true,true);
		assertTrue(EmployeeService.updateEmployee(employee));
	}
}

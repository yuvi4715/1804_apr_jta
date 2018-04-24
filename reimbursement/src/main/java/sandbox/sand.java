package sandbox;

import com.ranieri.model.Employee;
import com.ranieri.service.EmployeeService;

public class sand {

	
	public static void main(String[] args) {
		
		Employee test = EmployeeService.getEmployee("tester@test.com", "test");
		
		System.out.println(test);
	}
}

package sandbox;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranieri.model.Employee;
import com.ranieri.model.Request;
import com.ranieri.service.EmployeeService;
import com.ranieri.service.RequestService;

public class sand {

	
	public static void main(String[] args) {
//		
//		Employee test = EmployeeService.getEmployee("tester@test.com", "test");
//		
//		System.out.println(test);
//		
		ObjectMapper objectmapper = new ObjectMapper();
		
		List<Request> list = RequestService.getAllRequests();
		
		String data ="";
		for(Request x : list) {	
			data= data +x +"\n";
		}
		
		System.out.println(data);
		
		
		
	}
}

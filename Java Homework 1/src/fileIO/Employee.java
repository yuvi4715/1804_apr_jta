package fileIO;
// 26 inheriting from FileIO, this class creates employee objects with 4 instance variables
// 27 While parsing, the 4 attributes were tokenized and prepared.
// 28 4 Employees were created, with their information being parsed from person.txt. And then inserted into a HashMap
import java.util.HashMap;
import java.util.StringTokenizer;


public class Employee extends FileIO { // 26
	int employeeID;
	String firstName;
	String lastName;
	String role;
	HashMap<Integer, Object> hMap = new HashMap<Integer, Object>();
	
	public Employee() {
		tokenize();
		System.out.println("Employees are registered in hashmap...");
		System.out.println(hMap.toString()); // lists their ID and where they are stored in memory

	}
	
	public Employee(int employeeID, String firstName, String lastName, String role) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		
		
	}
	void tokenize(){  // 27
		st = new StringTokenizer(sb.toString(),":");
		int i = 0;
		while (st.hasMoreTokens() & i < 4) {
			 	employeeID = Integer.parseInt(st.nextToken());
			 	System.out.println("id: " + employeeID);
				firstName = st.nextToken();
				System.out.println("first: " + firstName);
				lastName = st.nextToken();
				System.out.println("last: " + lastName);
				role = st.nextToken();
				System.out.println("role: "+ role);
				
				buildAndStoreEmployee();
				i++;
				
				System.out.println("Employee "+ firstName + " " + lastName + " created.");
	     }
		
	}
	
	void buildAndStoreEmployee() { // 28
		Employee t = new Employee(employeeID, firstName, lastName, role);
		hMap.put(employeeID, t);
	}
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public static void main(String[] args) {
		Employee n = new Employee();
		
	}
	
}

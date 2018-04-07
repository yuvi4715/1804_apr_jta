package fileio_java;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @author katherine Obioha
 * 
 *         Question 24 - 28
 *
 *         Read a ser data from a file and use it to initialize the object
 *         Employee. Place the set of objects in a hash map using the employee
 *         ID as your key and the Employee Object as your Value.
 * 
 *         Question 42
 * 
 *         Use this class and implement the comparator interface to sort or
 *         compare an employee with Employee ID, firstname and last name.
 */
public class Employee implements Comparator<Employee> {

	private int EmployeeID;
	private String firstname;
	private String lastname;
	private String role;

	public Employee() {

	}

	public Employee(int employeeID, String firstname, String lastname, String role) {
		super();
		EmployeeID = employeeID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", firstname=" + firstname + ", lastname=" + lastname + ", role="
				+ role + "]";
	}

	// compare employeeID
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmployeeID() - o2.getEmployeeID();

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Employee p = null;
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

		// Reading from File
		FileReader file = new FileReader(
				"C:\\Users\\kathe\\OneDrive\\Documents\\workspace\\Java_One\\src\\main\\resources\\Employee.txt");
		Scanner in = new Scanner(file);
		System.out.println("Reading from file:");
		while (in.hasNextLine()) {

			String q = in.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(q, ":");
			while (tokenizer.hasMoreTokens()) {
				p = new Employee();
				p.setEmployeeID(Integer.parseInt(tokenizer.nextToken()));
				p.setFirstname(tokenizer.nextToken());
				p.setLastname(tokenizer.nextToken());
				p.setRole(tokenizer.nextToken());
			}
			map.put(p.getEmployeeID(), p);

		}

		System.out.println("Printing...");
		Set<Integer> ss = map.keySet();
		for (Integer n : ss) {
			Employee value = map.get(n);
			System.out.println(n + " :" + value);
		}
		in.close();
		System.out.println();
		System.out.println("Using the comparator interface in employee");
		compareEmployee();
	}

	private static void compareEmployee() {

		List<Employee> employee = new ArrayList<Employee>();
		// TODO Auto-generated method stub
		employee.add(new Employee(10, "You", "De", "Trainee"));
		employee.add(new Employee(12, "Lou", "Wani", "Trainer"));
		employee.add(new Employee(9, "New", "We", "Trainer"));
		employee.add(new Employee(0, "Too", "Lee", "Trainee"));

		// sort by firstname
		System.out.println("Compare by FirstName");
		Collections.sort(employee, (e1, e2) -> {
			return e1.getFirstname().compareTo(e2.getFirstname());
		});

		for (Employee r : employee) {
			System.out.println(r.toString());
		}
		System.out.println();
		// sort by lastname
		System.out.println("Compare by LastName");
		Collections.sort(employee, (e1, e2) -> {
			return e1.getLastname().compareTo(e2.getLastname());
		});

		for (Employee r : employee) {
			System.out.println(r.toString());
		}
		System.out.println(" ");
		// sort by ID
		System.out.println("Compare by ID");
		Collections.sort(employee, (e1, e2) -> {
			return e1.getEmployeeID() - e2.getEmployeeID();
		});

		for (Employee r : employee) {
			System.out.println(r.toString());
		}
	}

}

package advancedCodingExcercises;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
// problem 42 - created Multiple employee object and stored them in an arrayList. Using comparator to 
// sort hem based on name, department, and age.
public class Employee {
	
	String firstName;
	String department;
	int age;
	List<Employee> employee;
	
	public Employee() {
		createEmployees();
		System.out.println("Sorting by Name");
		Collections.sort(employee, Employee.eNameComparator);
		print();
		
		System.out.println(); // spacing
		System.out.println("Now Sorting by Department");
		Collections.sort(employee, Employee.eDepComparator);
		print();
		
		System.out.println(); // spacing
		System.out.println("Finally sorting by age");
		Collections.sort(employee, Employee.eAgeComparator);
		print();
		
		
	}
	
	
	public Employee(String firstName, String department, int age) {
		super();
		this.firstName = firstName;
		this.department = department;
		this.age = age;
		
		
	}

	void print() {
		for (Employee str: employee) {
			System.out.println(str);
		}
	}


	void createEmployees() {
		employee = new ArrayList<Employee>(); 
		employee.add(new Employee("Ash", "Pokemon", 13));
		employee.add(new Employee("BigBoss", "Diamond Dogs", 35));
		employee.add(new Employee("Venom", "Medic", 32));
		employee.add(new Employee("John", "UNFSC", 40));
		employee.add(new Employee("Samus", "Metroid", 22));
		
		
	}
	


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", department=" + department + ", age=" + age + "]";
	}



	// comparator for sorting by Name
	public static Comparator<Employee> eNameComparator = new Comparator<Employee>() {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			String eName1 = o1.getFirstName().toUpperCase();
			String eName2 = o2.getFirstName().toUpperCase();
			
			
			// Ascending order
			return eName1.compareTo(eName2);
		}
	};
	
	//comparator for sorting by Department
	public static Comparator<Employee> eDepComparator = new Comparator<Employee>() {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			String eDep1 = o1.getDepartment().toUpperCase();
			String eDep2 = o2.getDepartment().toUpperCase();
			
			
			// Ascending order
			return eDep1.compareTo(eDep2);
		}
	};
	
	// comparator for sorting by Age
	public static Comparator<Employee> eAgeComparator = new Comparator<Employee>() {
		
		@Override
		public int compare(Employee o1, Employee o2) {
			int eAge1 = o1.getAge();
			int eAge2 = o2.getAge();
			
			
			// Ascending order
			return eAge1 - eAge2;
		}
	};
	
	
	public static void main(String[] args) {
		Employee t = new Employee();
	}
}

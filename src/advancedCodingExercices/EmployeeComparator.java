package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 42
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeComparator 
{

	public static void main(String[] args) 
	{
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Tom","Johnson","Accounting","30"));
		empList.add(new Employee("Jerry","Smith","Intern","25"));
		empList.add(new Employee("Lisa","McBride","HR","27"));
		empList.add(new Employee("Gabriel","Stone","Manager","50"));
		empList.add(new Employee("Sarah","Johnson","HR","20"));

		System.out.println("List of Employees");
		for(Employee e: empList)
		{
			System.out.println(e);
		}
		
		Collections.sort(empList, new EmployeeHelper());
		//System.out.println("Sorting by First Name");
		//System.out.println("Sorting by Last Name");
		//System.out.println("Sorting by Department Name");
		System.out.println("Sorting by Age");
		for(Employee e: empList)
		{
			System.out.println(e);
		}
		
	}
	
}

class Employee
{
	String firstName,lastName,department,age;
	public Employee(String fN, String lN,String d,String a)
	{
		firstName = fN;
		lastName = lN;
		department = d;
		age = a;
		
	}
	@Override
	public String toString() 
	{
		return "Employee [FirstName = " + firstName + ", lastName = " + lastName + 
				", department = " + department +", age = "+ age + "]";
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public String getDepartment() 
	{
		return department;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}	
	
}

class EmployeeHelper implements Comparator<Employee>
{

	@Override
	public int compare(Employee emp1, Employee emp2)
	{
		
		//return emp1.getFirstName().compareTo(emp2.getFirstName());
		//return emp1.getLastName().compareTo(emp2.getLastName());
		//return emp1.getDepartment().compareTo(emp2.getDepartment());
		return emp1.getAge().compareTo(emp2.getAge());
	}
	
}
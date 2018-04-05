package Problem42;

public class Employee 
{
	private String FirstName, LastName, Department;
	private int age=0;
	public Employee(String fname, String lname, String department, int newage) 
	{
		FirstName = fname;
		LastName = lname;
		Department = department;
		age = newage;
	}
	
	public String getFirstName() 
	{
		return FirstName;
	}
	
	public void setFirstName(String fname) 
	{
		FirstName = fname;
	}
	
	public String getLastName() 
	{
		return LastName;
	}
	
	public void setLastName(String lname) 
	{
		LastName = lname;
	}
		
	public String getDepartment() 
	{
		return Department;
	}
	
	public void setDepartment(String dept) 
	{
		Department = dept;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int newage) 
	{
		age = newage;
	}

	
	public void print()
	{
		System.out.println("Name: " + FirstName + " " + LastName);
		System.out.println("Department: " + Department);
		System.out.println("Age: " + age);
		
	}
}

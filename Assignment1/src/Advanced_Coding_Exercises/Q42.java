//John Eifert
package Advanced_Coding_Exercises;

import java.util.Comparator;
import java.util.ArrayList;

public class Q42
{
	public static void main(String args[])
	{
		Q42 here = new Q42();
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(here.new Employee("Sonja", "Civil", 22));
		employees.add(here.new Employee("Hiroki", "Software", 24));
		employees.add(here.new Employee("John", "Software", 23));
		employees.add(here.new Employee("Mark", "Sales", 19));
		employees.add(here.new Employee("Alexander", "Acquisitions", 32));
		
		
		//Sort employees by name:
		employees.sort(here.new CompareName());
		System.out.println("Employees have been sorted by name.");
		for(int i=0; i<employees.size(); i++)
		{
			Employee workaround = (Employee) employees.get(i);
			System.out.println(workaround.getName() + " " + workaround.getDepartment() + " " + workaround.getAge());
		}
		System.out.print("\n \n");
		
		//Sort employees by department:
		employees.sort(here.new CompareDepartment());
		System.out.println("Employees have been sorted by department.");
		for(int i=0; i<employees.size(); i++)
		{
			Employee workaround = (Employee) employees.get(i);
			System.out.println(workaround.getName() + " " + workaround.getDepartment() + " " + workaround.getAge());
		}
		System.out.print("\n \n");
		
		//Sort employees by age:
		employees.sort(here.new CompareAge());
		System.out.println("Employees have been sorted by age.");
		for(int i=0; i<employees.size(); i++)
		{
			Employee workaround = (Employee) employees.get(i);
			System.out.println(workaround.getName() + " " + workaround.getDepartment() + " " + workaround.getAge());
		}
	}
	
	
	private class Employee
	{
		public String name;
		public String department;
		public int age;
		
		public Employee(String name, String department, int age)
		{
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public String getDepartment()
		{
			return department;
		}
		public void setDepartment(String department)
		{
			this.department = department;
		}
		public int getAge()
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
	}
	
	
	private class CompareName implements Comparator<Employee>
	{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			return o1.getName().compareTo(o2.getName());
		}
	}
	
	private class CompareDepartment implements Comparator<Employee>
	{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
	}
	
	private class CompareAge implements Comparator<Employee>
	{

		@Override
		public int compare(Employee o1, Employee o2)
		{
			return o1.getAge()-o2.getAge();
		}
		
	}
}

package Problem42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main42 {
	public static void main(String[] args) 
	{
		Employee a = new Employee("John", "Doe", "A", 42);

		Employee b = new Employee("Robert", "Smith", "B", 24);
		
		ArrayList<Employee> test = new ArrayList<Employee>();
		test.add(a);
		test.add(b);
		
		Collections.sort(test,new CompareName());
		for(Employee e:test)
			e.print();
		
		Collections.sort(test,new CompareAge());
		for(Employee e:test)
			e.print();
		
		Collections.sort(test,new CompareDept());
		for(Employee e:test)
			e.print();
	}
}

class CompareName implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
    {
        return a.getFirstName().compareTo(b.getFirstName());   
    }
}

class CompareAge implements Comparator<Employee>
{
	 public int compare(Employee a, Employee b)
	 {
		 return (a.getAge()-b.getAge());
	 }
}

class CompareDept implements Comparator<Employee>
{
	 public int compare(Employee a, Employee b)
	 {
		 return a.getDepartment().compareTo(b.getDepartment());
	 }
}
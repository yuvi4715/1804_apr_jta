package advancedCoding42;

import java.util.Comparator;

//Write Comparators to compare two employees based on their name, department, and age.


public class AdvancedCoding42
{
	
	public static void main(String[] args) 
	{
		AdvancedCoding42 employee1, employee2, employee3;
		employee1 = new AdvancedCoding42(25,"Accounting","Holly");
		employee2 = new AdvancedCoding42(32, "Marketing", "Michael");
		employee3 = new AdvancedCoding42(60, "Operations", "Jim");
		
		System.out.println(new EmployeeHelper().compare(employee1, employee2));
		System.out.println(new EmployeeHelper().compare(employee1, employee3));
	}
	
	
	    String Name;
		String department;
		int age;
		
		
		public AdvancedCoding42(int age, String department, String name) 
		{
			super();
			this.age = age;
			this.department = department;
			Name = name;
		}
		
		public int getAge() 
		{
			return age;
		}
		
		public void setAge(int age) 
		{
			this.age = age;
		}
		
		public String getDepartment() 
		{
			return department;
		}
		
		public void setDepartment(String department) 
		{
			this.department = department;
		}
		
		public String getName() 
		{
			return Name;
		}
		
		public void setName(String name) 
		{
			Name = name;
		}
		
	
	}

	class EmployeeHelper implements Comparator<AdvancedCoding42>
	{

		@Override
		public int compare(AdvancedCoding42 employee1, AdvancedCoding42 employee2) 
		{
			if(employee1.getAge() == employee2.getAge() 
					&& employee1.getDepartment().equals(employee2.getDepartment())
					&& employee1.getName().equals(employee2.getName()))
				return 0;
			else
				return 1;
			
		}
}
	

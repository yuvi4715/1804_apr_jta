package main.Model;


public class Employee {
	
	private String email;
	private String password;
	private String name;
	
	public Employee(String e, String pass, String n)
	{
		email = e;
		password = pass;
		name = n;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String e)
	{
		email = e;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String p)
	{
		password= p;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
}

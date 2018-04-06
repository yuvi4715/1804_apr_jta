package FileIO;

public class Employee 
{
	private int id;
	public String FName;
	public String LName;
	private String Role;
	
	public Employee(String a, String b, String c, String d)
	{
		id = Integer.parseInt(a);
		FName = b;
		LName = c;
		Role = d;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getFname()
	{
		return FName;
	}
	
}

package Problem7and8;

public class Customer 
{
	private final String LocShopped = "Test Store.";
	private static String FirstName = "John";
	private static String LastName = "Doe";
	private double charge;
	
	public Customer()
	{
		charge = 0.0;
	}
	//constructor 2
	public Customer(String fn, String ln, double c)
	{
		ChangeFirstName(fn);
		ChangeLastName(ln);
		charge = c;
	}
	//overloaded m1
	public void addcharge(int x)
	{
		charge += x;
	}
	//overloaded m2
	public void addcharge(double x)
	{
		charge += x;
	}

	//static m1
	private static void ChangeFirstName(String x)
	{
		FirstName = x;
	}
	
	//static m2
	private static void ChangeLastName(String x)
	{
		LastName = x;
	}

	public void ChangeName(String fn, String ln)
	{
		ChangeFirstName(fn);
		ChangeLastName(ln);
	}
	
	public double getCharge()
	{
		return charge;
	}
	
	public String getLoc()
	{
		return LocShopped;
	}
	
	public String getName()
	{
		return FirstName + " " + LastName;
	}
}
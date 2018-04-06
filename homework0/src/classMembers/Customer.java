package classMembers;

public class Customer
{
	public static int queue;
	public static final int STORE_NUMBER = 1234;
	String name;
	int orderNumber;
	public Customer()
	{
		name = "";
		orderNumber = 0;
		queue++;
	}
	public Customer(String n, int o, String[] i)
	{
		name = n;
		orderNumber = queue++;;	
	}
	
	private void removeCustomer()
	{
		queue--;
	}
	
	public void removeCusomer(Customer c)
	{
		c.removeCustomer();
	}
	
	public int getOrderNumber()
	{
		return orderNumber;
	}
	
	public static int getStoreNumber()
	{
		return STORE_NUMBER;
	}
	
	public static int getQueue()
	{
		return queue;
	}
	
}

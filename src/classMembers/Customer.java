package classMembers;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 7 + 8
 */
public class Customer
{
	public static int queue;  ////static variable
	public static final int STORE_NUMBER = 1234; ///// final variable
	String name;
	int orderNumber;
	//////Constructor one/////////
	public Customer()
	{
		name = "";
		orderNumber = 0;
		queue++;
	}
	////////////////////////////
	
	//////////Constructor two////////////
	public Customer(String n, int o, String[] i)
	{
		name = n;
		orderNumber = queue++;;	
	}
	////////////////////////////////////
	
	////////////normal method/////////
	private void removeCustomer()
	{
		queue--;
	}
	///////////////////////////////////
	
	///////////overloaded method/////////
	public void removeCusomer(Customer c)
	{
		c.removeCustomer();
	}
	////////////////////////////////////
	
	public int getOrderNumber()
	{
		return orderNumber;
	}
	
	
	/////////static methods//////////
	public static int getStoreNumber()
	{
		return STORE_NUMBER;
	}
	
	public static int getQueue()
	{
		return queue;
	}
	////////////////////////////////
	
}

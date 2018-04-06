package classMembers;

public class CustomerMain 
{

	
	public static void main(String[] args) 
	{
		String[] aList = {"chicken","soap","shoes"};
		Customer c1 = new Customer();
		Customer c2 = new Customer("John Smith",Customer.queue, aList);
		c1.getOrderNumber();
		c2.getOrderNumber();
		c1.removeCusomer(c1);
		Customer.getStoreNumber();
		Customer.getQueue();

	}

}

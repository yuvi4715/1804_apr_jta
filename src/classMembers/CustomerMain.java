package classMembers;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 7 + 8
 */
public class CustomerMain 
{

	
	public static void main(String[] args) 
	{
		String[] aList = {"chicken","soap","shoes"};
		
		///create two customers/////
		Customer c1 = new Customer();
		Customer c2 = new Customer("John Smith",Customer.queue, aList);
		////////////////////////////
		
		//////////each class member//
		c1.getOrderNumber();
		c2.getOrderNumber();
		c1.removeCusomer(c1);
		Customer.getStoreNumber();
		Customer.getQueue();
		/////////////////////////////
	}

}

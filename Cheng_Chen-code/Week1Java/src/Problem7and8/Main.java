package Problem7and8;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Customer cus1 = new Customer();
		System.out.println("Testing. \nName: " + cus1.getName());
		
		Customer cus2 = new Customer("Jackie1","Chen1", 12.52);
		cus2.addcharge(2);
		cus2.addcharge(5.48);
		cus2.ChangeName("Jackie", "Chen");
		System.out.println("Customer Name: " + cus2.getName());
		System.out.println("You shopped at: " + cus2.getLoc());
		System.out.println("You will be charged: " + cus2.getCharge());

	}

}

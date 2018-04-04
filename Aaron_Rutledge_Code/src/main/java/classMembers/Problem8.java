package classMembers;

public class Problem8 {
	
	public static void main(String[] args) {
		
		Problem7.Customer c1 = new Problem7.Customer();
		Problem7.Customer c2 = new Problem7.Customer("Aethlind", 10.0f);
		
		c2.setBalance(15.3f);
		c2.setName("Aoife");
		
		System.out.println(c2.getBalance());
		System.out.println(c2.getName());
		System.out.println(c1.getCustID());
		
		System.out.println(Problem7.Customer.getNumCust());
		
		Problem7.Customer.resetCustomers();
		System.out.println(Problem7.Customer.getNumCust());
		
		c2.updateBalance(3);
		
		System.out.println(c2.getBalance());
		
	}
	

}

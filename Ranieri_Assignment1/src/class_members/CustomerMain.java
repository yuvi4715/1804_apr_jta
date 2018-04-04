package class_members;

public class CustomerMain {

	public static void main(String[] args) {
		
		Customer adam = new Customer(0001, 100000);
		Customer aaron = new Customer(0002);
				
		// static methods
		// first method is an introduction to become a member
		// second method shows the total number of customers
		Customer.intro();
		Customer.numberOfCustomers();
		
		
		adam.showBalance();
		aaron.showBalance();
		
		adam.credit(500);
		adam.credit(500,"paycheck");
		adam.debit(200, "rent money");
		adam.showBalance();
		
		
		aaron.debit(200," -$200 for failure to pay last months rent");
		aaron.showBalance();
		
		aaron.showHistory();
		adam.showHistory();
		
		

	}

}

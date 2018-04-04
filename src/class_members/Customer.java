package class_members;

public class Customer {
	
	private final int customerID;
	static int totalCustomers;
	private double balance;
	private String history;
	
	// create accpount with a balance
	public Customer(int customerID, double balance) {
		super();
		this.customerID = customerID;
		this.balance = balance;
		this.history = "account created with deposit";
		++totalCustomers;
	}
	
	// create account without having an initial amount
	public Customer(int customerID) {
		super();
		this.customerID = customerID;
		this.balance = 0;
		this.history = "account created without initial deposit";
		++totalCustomers;
	}
	
	public void showHistory() {		
		System.out.println(this.history);;	
	}
	
	public void credit(double money) {		
		this.balance = this.balance +money;	
	}
	
	public void credit(double money, String comment) {		
		this.balance = this.balance +money;	
		this.history = this.history+"\n" + comment;
	}
	
	
	public void debit(double money) {		
		this.balance = this.balance - money;	
	}
	
	public void debit(double money, String comment) {		
		this.balance = this.balance - money;	
		this.history = this.history+"\n" + comment;
	}
	
	public void showBalance() {		
	
		System.out.println(this.balance);
	}
	
	public static void numberOfCustomers() {		
		
		System.out.println(totalCustomers);
	}
	
	public static void intro() {
		System.out.println("Come join Ranieri client services. We value each and very customer hurry up and join already");
		
	}
	
	// calculates bonus money put into account if they were to join today
	public static double bonus (double money) {
				
		return money*.05;
	}
	
	

}

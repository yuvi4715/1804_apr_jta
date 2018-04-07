package classMembers;

// problem 7 - designed to be inherited by class in problem 8.
//  		Customer classed created with required methods and
//			and variables.
public class Customer {
	
	String firstName;
	String lastName;
	String item;
	int purchase;
	int credit;
	final int storeNumber = 214;  // final var
	static int departmentNumber = 12; // static var
	
	public Customer() { // default constructor
		
		
	}
	
	public Customer(String firstName, String lastName) { // parameterized constructor
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Transaction history logged at Store# " + getStoreNumber()); // used to get store number since it is Final
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPurchase() {
		return purchase;
	}
	
	public int getPurchase(int itemIncluded) { //overloads getPurchase, just needs to take argument to report
		
		System.out.println("Item Purchased is " + item);
		return purchase;
	}
	
	public void setPurchase(int purchase, String item) { // overloads setPurchase
		this.purchase = purchase;
		this.item = item;
	}

	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public static int getDepartmentNumber(){ // static method
	
		return departmentNumber;
	}
	
	public static String isHappy(int entry) {  // second static method
		String happy = "no";
		if (entry == 1) {
			happy = "Yes" ;
		}
		
		
		return happy;
	}


	public int getStoreNumber() {
		return storeNumber;
	}

	
	
}
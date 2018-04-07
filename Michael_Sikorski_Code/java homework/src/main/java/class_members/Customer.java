package class_members;

public class Customer {

	static int customerCount = 0;
	final static String storeName = "Best Buy";

	private String first_name, last_name;
	private Double balance;

	public Customer(String first, String last) {
		first_name = first;
		last_name = last;
		customerCount++;
	}

	public Customer(String first, String last, double balance) {
		first_name = first;
		last_name = last;
		this.balance = balance;
		customerCount++;
	}

	public static void shop() {
		System.out.println("The Customer does some shopping.");
	}

	public static void enter() {
		System.out.println("A customer has entered the store.");
	}

	public static void leave() {
		System.out.println("A customer has left the store.");
	}

	@Override
	public boolean equals(Object obj) {
		Customer compare = (Customer) obj;
		boolean condition1 = this.first_name == compare.first_name;
		boolean condition2 = this.last_name == compare.last_name;
		boolean condition3 = this.balance == compare.balance;
		return (condition1 && condition2 && condition3);
	}

	@Override
	public String toString() {
		String ret = "ID: " + first_name;
		ret += ", " + last_name;
		return ret;
	}

}

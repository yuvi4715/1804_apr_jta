package class_members;
//Kevin Rivera - Revature
//Assignment Week 1: Class members - Problem 8.
//This class tests the Customer class.

public class Customer_Test {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer(12);
		
		System.out.println("Testing class members: " + Customer.code);
		System.out.println("Testing class members: " + Customer.ID);
		System.out.println("Testing class members: " + Customer.getID());
		System.out.println("Testing class members: " + Customer.getID(2));
		System.out.println("Testing class members: " + Customer.printCode());
		System.out.println("Testing class members: " + Customer.printCode(2));

	}
}

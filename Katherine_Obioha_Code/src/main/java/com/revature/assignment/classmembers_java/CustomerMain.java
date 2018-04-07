package classmembers_java;

import java.util.Scanner;

/**
 * 
 * @author katherine Obioha
 * 
 *         Question 8 . use each of the class members in question 7 and create
 *         at least 2 customers
 *
 */
public class CustomerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		Customer customer1 = new Customer("Katherine");
		Customer customer2 = new Customer("Katherine", "Gen");
		Customer customer3 = new Customer();

		// Customer1
		System.out.println("Welcome" + " " + customer1.getname() + "! "
				+ "If you are an old Customer, enter 1. If you are a new customer, enter any other number");
		int y = in.nextInt();
		customer1.setCustomerType(y);
		System.out.println("Thank you for visiting." + " " + "You are a" + " " + customer1.getcustomertype() + ". "
				+ "You can checkout a maximum of" + " " + Customer.maximumcartitems + "items");

		// Customer2
		System.out.println("Welcome" + " " + customer2.getname() + "! "
				+ "If you are an old Customer, enter 1. If you are a new customer, enter any other number");
		y = in.nextInt();
		customer1.setCustomerType(y);
		System.out.println("Thank you for visiting." + " " + "You are a" + " " + customer2.getcustomertype() + ". "
				+ "You can checkout a maximum of" + " " + Customer.maximumcartitems + "items");

		// customer3
		customer3.setFirstname("Karen");
		customer3.setLastname("Johnson");

		System.out.println("Welcome" + " " + customer3.getname() + "! "
				+ "If you are an old Customer, enter 1. If you are a new customer enter any other number");
		y = in.nextInt();
		customer3.setCustomerType(y);
		System.out.println("Thank you for visiting." + " " + "You are a" + " " + customer3.getcustomertype() + " "
				+ "You can checkout a maximum of" + ". " + Customer.maximumcartitems + "items");

	}

}

package assignment.Joey.Customer;

import org.apache.commons.lang3.RandomStringUtils;

import assignment.Joey.Exceptions.Exception1;

/**
 * a main method for customer class that:
   1. Creates 2 customers
   2. Uses each of the Customer class members
 * @author joeyi
 *
 */
public class CustomerMain {
	public static void main(String[] args) throws Exception1 {
		String x = RandomStringUtils.randomAlphabetic(6);
		new Customer(x); //random string of 6 length
		Customer a = new Customer("John");
		Customer b = new Customer();
		Customer.printCustomerList();
		Customer.getCustomerInfo("John");
		b.getCustomerUsername();
		Customer.getCustomerInfo(a.getCustomerAccount());
		a.getCustomerNumber();
		b.getCustomerNumber();
		a.toString();
		b.toString();
		System.out.println("There are a total of "+Customer.customerList.size()+" customers");
	
	}
	/*
	// instantiate Integer objects
	Integer firstInteger = 100;
	Integer secondInteger = new Integer(100);
	Integer thirdInteger=100;
	// test for equality
	System.out.println(firstInteger==secondInteger);	
	System.out.println(firstInteger==thirdInteger);
    Integer x =2;
    addNum(x);
	Can pass in but automatically boxed into int
	public static void addNum(int a) { 
		if (a==0) System.out.println("a=0");
		//if (!a) System.out.println();
		}*/

}

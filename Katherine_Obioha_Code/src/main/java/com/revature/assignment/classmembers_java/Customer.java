package classmembers_java;

/**
 * 
 * @author katherine obioha
 *
 *         Question 7.
 * 
 *         2 constructors, 2 overloaded method, 2 static variables, 1 final
 *         variables
 */
public class Customer {

	String firstname;
	String lastname;
	static String customertype;
	static final int maximumcartitems = 7;

	// constructor 1
	public Customer() {

	}

	// overload method 1 and constructor 2
	public Customer(String name) {
		this.firstname = name;

	}

	// overload method 2 and constructor 3
	public Customer(String firstname, String lastname) {
		this.lastname = lastname;
		this.firstname = firstname;

	}

	// static method 1
	static void setCustomerType(int i) {
		if (i == 1) {
			customertype = "Regular Customer";
		} else {
			customertype = "New Customer";
		}

	}

	String getname() {
		return firstname + " " + (lastname != null ? lastname : " ");
	}

	// static method 2
	static String getcustomertype() {
		return customertype;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}

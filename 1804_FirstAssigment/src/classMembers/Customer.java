package classMembers;

public class Customer {

//	Create a Customer class with:
//	At least 2 constructors
//	At least 2 overloaded methods
//	At least 1 static variable
//	At least 2 static methods
//	At least 1 final variable
	
	
	public static final String SuperMarket = "Target";
	public String CustomerName;
	public int CustomerNumber;
	
	public Customer() {
		this.AssignCustomerInformation(500, "Juan del Pueblo");
		System.out.println("Name: " + CustomerName  + " Customer Number: " + CustomerNumber);
		System.out.println("Proud customer of " + SuperMarket);
		
	}
	
	
	public Customer(int CustNum) {
		this.AssignCustomerInformation(CustNum, CustomerName);
		System.out.println("Name: " + CustomerName  + " Customer Number: " + CustomerNumber);
		System.out.println("Proud customer of" + SuperMarket);
	
		
	}
	
	
	public void AssignCustomerInformation(int num, String str) {
		CustomerNumber = num;
		CustomerName = str;
		
	}
	
	public void AssignCustomerInformation(String str, int num) {
		CustomerNumber = num;
		CustomerName = str;
		
	}
	
	static void MyMethod(int x) {
		System.out.println("MyMethod");
		
		
	}
	
	static void MyStaticMethod2() {
		System.out.println("MyStatic2");
		
	}
	
	
}

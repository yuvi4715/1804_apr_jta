package assignment_wk_1;

class Customer {
	// TODO
	// 2 constructors, they overload each other
	// 1 static variable, basically a global variable in the static method
	// 2 static methods, methods that contain only static variables and calls only static methods
	// 1 final variable

	// 2 overloaded methods, methods same name diff params
	
	//final variables, 100th customer
	//static variable, shopping cart counter
	//static method, customer counter
	//static method, take shopping cart
	//static method, return shopping cart
	
	
	final int customerNumber;
	static int luckyCustomerCounter;
	
	// demographic
	private String name;
	private int age;
	
	

	// constructor
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		customerNumber = luckyCustomerCounter;
	}

	// default constructor
	public Customer() {
		name = "";
		age = -1;
		customerNumber = luckyCustomerCounter;
	}
	

	public void greet() {
		System.out.println("Hello!");
	}
	
	public void greet(String name) {
		System.out.println("Hello " + name + "!");
	}
	
	
	//2 static methods
	public static void incLuckyCustomer() {
		luckyCustomerCounter++;
	}
	
	public static void setCustomerCounter(int todaysCustomerCounter) {
		luckyCustomerCounter = todaysCustomerCounter;
	}

	
	
	
	
	//getter/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	

	
	
}

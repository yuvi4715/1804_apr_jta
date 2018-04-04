package com.revature.assignments.weekone.classmembers;

public class Customer {
	private String name;
	private final int id;
	private final int joinDate;
	public static String storeName = "Tim's Door of Store";
	public static int storeOrginDate = 1989;

	public Customer() {
		this.name = ("No Name given");
		id = 16665;
		joinDate = 2018;
	}

	public Customer(String Name) {
		setName(Name);
		id = 16666;
		joinDate = 2018;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public static String getStoreName() {
		return storeName;

	}

	public static String getStoreName(boolean temp) {
		if (temp) {
			return (storeName + ", A open door policy");
		}
		return storeName; 
	}

	public static int getStoreOrginDate() {
		return storeOrginDate;

	}
	
	public static int getStoreOrginDate(boolean temp) {
		if (temp) {
			return (2018 - storeOrginDate);
		}
		return storeOrginDate; 
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + "]";
	}


	public static void main(String[] args) {
		Customer newUser1 = new Customer();
		System.out.println(newUser1.getName());
		System.out.println(newUser1.getId());
		newUser1.setName("Not Tim");
		System.out.println(Customer.getStoreName());
		System.out.println(Customer.getStoreName(true));
		System.out.println(Customer.getStoreOrginDate());
		System.out.println(Customer.getStoreOrginDate(true));
		System.out.println(newUser1.toString());
		
		Customer newUser2 = new Customer("Fred");
		System.out.println(newUser2.getName());
		System.out.println(newUser2.getId());
		newUser2.setName("Really not Tim");
		System.out.println(Customer.getStoreName());
		System.out.println(Customer.getStoreName(true));
		System.out.println(Customer.getStoreOrginDate());
		System.out.println(Customer.getStoreOrginDate(true));
		System.out.println(newUser2.toString());
		
		
	}
	

}

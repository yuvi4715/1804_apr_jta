package com.revature.assignments.weekone.classmembers;

public class Customer {
	private String name;
	private final int id;
	public static String storeName = "Tim's Door of Store";

	public Customer() {
		setName("No Name given");
		setId(int((Math.random());
	}

	public Customer(String Name) {
		setName(this.name);
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
	public void setId(int id) {
		this.id = id;
	}

}

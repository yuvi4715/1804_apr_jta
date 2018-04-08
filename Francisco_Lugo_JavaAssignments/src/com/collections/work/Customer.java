package com.collections.work;

import java.util.Comparator;

public class Customer implements Comparable<Customer>, Comparator<Customer> {

	private String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void thisIs() {
		System.out.println("This is a " + name +".");
	}

	@Override
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	

	@Override
	public int compare(Customer o1, Customer o2) {
		return o1.name.compareTo(o2.name);
	}
}

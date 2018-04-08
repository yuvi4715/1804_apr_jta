package com.collections.work;

import java.util.Comparator;

public class CustomerA implements Comparator<CustomerA>{
	
	String name;

	public CustomerA(String name) {
		this.name = name;
	}

	public void thisIs() {
		System.out.println("This is a " + name + ".");
	}

	@Override
	public int compare(CustomerA o1, CustomerA o2) {
		return o1.name.compareTo(o2.name);
	}

}

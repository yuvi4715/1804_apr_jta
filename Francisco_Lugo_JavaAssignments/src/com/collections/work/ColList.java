package com.collections.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class ColList  {

	static Customer c1 = new Customer("Tom");
	static Customer c2 = new Customer("Bob");
	static Customer c3 = new Customer("Jerry");
	static CustomerA ca1 = new CustomerA("Tom");
	static CustomerA ca2 = new CustomerA("Bob");
	static CustomerA ca3 = new CustomerA("Jerry");
	
	static ArrayList<CustomerA> aList = new ArrayList<CustomerA>();
	static LinkedList<CustomerA> lList = new LinkedList<CustomerA>();
	static HashSet<Customer> hSet = new HashSet<Customer>();
	static Set<Customer> tSet = new TreeSet<Customer>();
	static HashMap<Customer, Integer> hMap = new HashMap<Customer, Integer>();
	
	public static void main(String[] args) {
		
		CustomerA cusa;
		aList.add(ca1);
		aList.add(ca2);
		aList.add(ca3);
		Collections.sort(aList, (o1, o2) -> o1.name.compareTo(o2.name));
		
		System.out.println("Reading arrayList...");
		for(int i =0; i < 3; i++) {
			cusa = aList.get(i);
			cusa.thisIs();
		}
		
		lList.add(ca1);
		lList.add(ca2);
		lList.add(ca3);
		Collections.sort(lList, (o1, o2) -> o1.name.compareTo(o2.name));
		
		System.out.println("Reading linkedList...");
		for(int i =0; i < 3; i++) {
			cusa = lList.get(i);
			cusa.thisIs();
		}
		
		tSet.add(c1);
		tSet.add(c2);
		tSet.add(c3);
		System.out.println("Reading TreeSet...");
		
		for(Customer c : tSet) {
			c.thisIs();
		}
		
		hSet.add(c1);
		hSet.add(c2);
		hSet.add(c3);
		
		System.out.println("Reading HashSet...");
		Iterator<Customer> it1 = hSet.iterator();
		
		while(it1.hasNext()) {
			it1.next().thisIs();
		}
		
		hMap.put(c1, 1);
		hMap.put(c2, 2);
		hMap.put(c3, 3);
		
		System.out.println("Reading HashMap");
		
		Set<Customer> keys = hMap.keySet();
		for(Customer cust: keys) {
			cust.thisIs();
			System.out.println(" - He has the key: " + hMap.get(cust) );
			
		}
	}
	
	
	
	
}

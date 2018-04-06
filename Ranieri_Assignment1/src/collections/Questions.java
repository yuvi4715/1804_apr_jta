package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import file.io.*;
public class Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee tim = new Employee("76", "Tim","Davidson","developer");
		Employee bob = new Employee("77", "Bob","Smith","developer");
		Employee kat = new Employee("78", "kat","Berg","sales");
		
		//Array list
		ArrayList<Employee> companyA = new ArrayList<>();
		companyA.add(tim);
		companyA.add(bob);
		companyA.add(kat);
		kat.setAge(40);
		tim.setAge(30);
		bob.setAge(20);
		
//		Collections.sort(companyA, new employeeSorterAge());
		
		
		// Prints all		
		for (Employee e : companyA) {
			System.out.println(e);
	}
//		
		
		Collections.sort(companyA,new employeeSorter());
		// Prints all
//		for (Employee e : companyA) {
//			System.out.println(e);
//		}
//		
		
		//Linked list
		LinkedList<Employee> companyL = new LinkedList<>();
		companyL.add(tim);
		companyL.add(bob);
		companyL.add(kat);
		
		//Prints all
		Collections.sort(companyL,new employeeSorter());
//		for (Employee e : companyL) {
//			System.out.println(e);
//		}
//		
		//Hash map
		HashMap<String, Employee> companyHM = new HashMap<>();
		companyHM.put("Timmy",tim);
		companyHM.put("Bobby",bob);
		companyHM.put("Katie",kat);
		
//		System.out.println(companyHM.keySet());
		// cannot iterate HashMap
//		for (Employee e : companyHM) {
//			System.out.println(e);
//		}
		
//		System.out.println(companyHM.get("Timmy"));
		
		// TreeSet
		Set<Employee> companyTS = new TreeSet<>(new employeeSorter());
		companyHM.put("Timmy",tim);
		companyHM.put("Bobby",bob);
		companyHM.put("Katie",kat);
		
		// prints out nothing
//		for (Employee e : companyTS) {
//			System.out.println(e);
//		}
////		
//		System.out.println(companyHM.get("Bobby"));
		
		//HashSet
		Set<Employee> companyHS = new HashSet<>();
		companyHS.add(tim);
		companyHS.add(bob);
		companyHS.add(kat);
	
		// prints bob kat tim
//		for (Employee e : companyHS) {
//			System.out.println(e);
//		}
//		
	
		
		
		

	}
	
	

}

// several comparators comment one out to sort it.

 class employeeSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int result = o1.getLastName().compareTo(o2.getLastName());
		if (result != 0 ) {			
			return result;
		}
		
		return o1.getLastName().compareTo(o2.getLastName());
	}
	
	class employeeSorterRole implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			
			int result = o1.getRole().compareTo(o2.getRole());
			if (result != 0 ) {			
				return result;
			}
			
			return o1.getRole().compareTo(o2.getRole());
		}
	
	}
	
	
	
	class employeeSorterAge implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			
			int result = o1.getAge() - o2.getAge();
									
				return result;
				
			
		}
	
	}
	
	}
	
	
	
	
	
	
	

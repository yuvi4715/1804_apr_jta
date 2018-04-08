package com.revature.projrctzero;

import java.util.Comparator;

public class Quetsion42CompareTo {
	

	
	//Question: Using Java Write Comparators to compare two employees based on their name, department, and age. 

public static void main(String[] args) {

	
	 //Name Comparator:
	    Comparator<Quetsion42CompareTo> Name_Comparator = new Comparator<Quetsion42CompareTo>() {

	        @Override
	        public int compare(Quetsion42CompareTo emp1, Quetsion42CompareTo emp2) {
	            return emp1.getName().compareTo(emp2.getName());
	        }
	    };
	//Age Comparator:
	 Comparator<Quetsion42CompareTo> Age_Comparator = new Comparator<Quetsion42CompareTo>() {

	        @Override
	        public int compare(Quetsion42CompareTo emp1, Quetsion42CompareTo emp2) {
	            return emp1.getAge() - emp2.getAge();
	        }
	    };
		

}

	protected int getAge() {
		// TODO Auto-generated method stub
		
		char[] getAge = null;
		System.out.println(getAge);
		return 0;
	}

	protected String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
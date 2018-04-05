package com.revature.classmembers;

public class customerClassMembers extends CuctomerClass{

	public static void main(String[] args) {
		new CuctomerClass();
		new CuctomerClass("Bala");
		CuctomerClass ref = new CuctomerClass();
		ref.redBox("Bala","coco");
		ref.redBox("kumar", "15th street", "coco");
		ref.returnStatus(true);
		ref.movieRating(4,"coco");

		System.out.println("\nThis Out is For 2 newly created customers");
		CuctomerClass One = new CuctomerClass("John");
		CuctomerClass Two = new CuctomerClass("Mike");
		
		One.redBox("Jhon", "Bill Board");
		Two.redBox("Mike", "Shape Of Water");
		
	}

}

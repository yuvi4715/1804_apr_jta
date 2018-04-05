package com.revature.classmembers;

public class CuctomerClass {
	
	final int customerID = 5;
	String customerName;
	String customerAddress;
	boolean movieReturnStatus;
	static String movieRented;
	static int movieRating;
	
	

	
	CuctomerClass(){
		//customerID = ID;
		System.out.println("Customer ID is " + customerID);
		}
	CuctomerClass(String name){
		customerName = name;
		System.out.println("Customer name is " + customerName);
	}
	
	public void redBox(String customerName, String movieRented) {
		System.out.println( customerName + " has rented the movie " + movieRented);
	}
	
	public void redBox(String customerName,String customerAddress, String movieRented) {
		System.out.println( customerName + " in "+ customerAddress +"has rented the movie " + movieRented);
	}
	
	public static void returnStatus(boolean movieReturnStatus) {
		if(movieReturnStatus == true) {
			System.out.println("Dvd has been returned to RedBox Store");
		}else {
			System.out.println("Dvd has not been returned to RedBox Store");	
		}
	}
	
	public static void movieRating(int movieRating, String movieRented) {
		
			System.out.println("Customer rating for "+" " + movieRented +" is " + movieRating + " out of 5");
		
	}
	
	//Methods are called from the customerClassMembers.java file
	//Output of both CuctomerClass.java and customerClassMembers.java can be executed fromcustomerClassMembers.jave
	
	
	

}

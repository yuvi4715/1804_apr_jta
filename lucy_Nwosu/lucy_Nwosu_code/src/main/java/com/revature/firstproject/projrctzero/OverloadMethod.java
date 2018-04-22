package com.revature.projrctzero;

public class OverloadMethod {
	
	int itemsIncartA, itemsIncartB;
	double costOfBread, costOfSugar;
	String a,b;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Customer Name:			"+Add("Lucy","Nwosu"));
	System.out.println("Total number of items in cart:	"+ Add(2,3));
	System.out.println("Total cost of items bought:	"+"$"+Add(2.99,7.53));
	
		}
	
	public static int Add (int itemsIncartA, int itemsIncartB) {
		return(itemsIncartA + itemsIncartB);
	}
	
	public static double Add (double costOfBread,double costOfSugar) {
		return(costOfBread + costOfSugar);

}
	public static String Add (String a, String b) {
		return(a+b);
}
}

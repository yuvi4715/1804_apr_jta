package com.revature.oop;

public class DareDevil extends GiftedPeople {
	
	String armor = "Blue";
	
	public void giftedPowers() {
		System.out.println("Good hearing");
	}
	Boolean demons(String stick) {
		Boolean calm = false;
		System.out.println("Losing his father");
		System.out.println(stick + " helps murdock to calm down");
		
		if(stick != null) {
			calm = true;
			
		}
		return calm;
	}
	void occupation() {
		System.out.println("is lawyer");
	}
	
	public static void main(String[] args) {
		GiftedPeople g1 = new GiftedPeople();
		DareDevil d1 = new DareDevil();
		GiftedPeople g2 = new GiftedPeople();
		DareDevil d2 = new DareDevil();
	}
	
	

}

package com.revature.oop;

public class DareDevil extends GiftedPeople {
	String armor = "blue";
	void giftedPowers() {
		System.out.println("Blind with enhanced senses and visibility");
	}
	
	boolean demons(String stick) {
		boolean calm = false;
		System.out.println("Dare devil - demons - Losing his father");
		System.out.println(stick + " helps murdock to calm down a little bit ");
		if (stick.contains("stick")) {
			calm = true;
		}
		else {
			System.out.println("Stick/Nelson/Karen could not help Mr. Murdock");
		}
		return calm;
	}
	
	void occupation() {
		System.out.println("Dare devil is a lawyer");
	}
	
	public static void main(String[] args) {
		GiftedPeople g1 = new GiftedPeople();
		DareDevil d1 = new DareDevil();
		GiftedPeople g2 = new DareDevil();
		//DareDevil d2 = new GiftedPeople(); //not an example for IS-A relationship
		GiftedPeople g3 = new JessicaJones();
	}
}

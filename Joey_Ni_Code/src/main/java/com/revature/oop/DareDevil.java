package com.revature.oop;

public class DareDevil extends GiftedPeople {
    
	String armor = "blue";
	
	public void giftedPowers() {
		System.out.println("blind with enhanced senses and visibility");
	}
	

	public boolean demons(String stick) {
		boolean calm=false;
		System.out.println("losing his father");
		System.out.println(stick + "helps murdock to calm down");
		if (stick.contains("stick")) calm=true;
		else System.out.println("stick not here to help");
		return calm;
		
	}
	
	public void occupation() {
		System.out.println("dare devil is a lawyer");
	}
	
	
	public static void main(String[] args) {
		GiftedPeople g1=new GiftedPeople();
		DareDevil d1 = new DareDevil();
		GiftedPeople g2 = new DareDevil();
		//DareDevil d2=new GiftedPeople();
		//Not an "IS-A" relationship
		GiftedPeople g3 = new JessicaJones();
		System.out.println(g1.hashCode());
	}
}

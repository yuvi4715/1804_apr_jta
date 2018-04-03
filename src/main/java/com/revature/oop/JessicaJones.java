package com.revature.oop;

public class JessicaJones extends GiftedPeople{

	void canStopCars() {
		System.out.println("Probably the slow moving cars can be stopped.");
	}
	
	void jump() {
		System.out.println("Can jump from the tallest building in the world.");
	}
	
	void giftedPowers() {  //The parent's giftedPowers is being overriden. 
		System.out.println("Jessica got the mad hops. ");
	}
	
	void daemons() {
		System.out.println("Jessica's darkest demon is Killgrave.");
	}
	
}

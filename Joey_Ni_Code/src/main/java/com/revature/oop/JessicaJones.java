package com.revature.oop;

public class JessicaJones extends GiftedPeople{

		void canStopCars() {
			System.out.println("cars stopped");
		}
		
		void jump() {
			System.out.println("can jump from tall buildings and not die");
		}
		
		//when overriding lower scope cause problems, error, 
		//has to be as visible or more visible than parent
		public void giftedPowers() {
			System.out.println("like spiderman");
		}
		
		public void demons() {
			System.out.println("Jessica's darkest demon is kilgrave");
		}
		
		public void friends(String s1) {
			System.out.println("Jessica has a friend named " + s1);
		}
		
		public void friends(String s1, String s2) {
			System.out.println("Jessica has two friends named " +s1 +" and " +s2);
		}
		
}

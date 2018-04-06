package oop;
// Mammal class that extends  Animal, but does not override walk. For this to work, it has to be an abstract class
abstract class Mammal implements Animal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I just ate some plant");
	}
	
	static void walk() {
		System.out.println("I walk on all fours");
	}

	

}

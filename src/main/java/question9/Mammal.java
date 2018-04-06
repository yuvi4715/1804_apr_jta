package question9;

public abstract class Mammal implements Animal{
	
	public void eat() {
		System.out.println("Mammal is eating");
	}
	
	static void walk() {
		System.out.println("Mammal is walking");
	}
}

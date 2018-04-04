package problems1to9;
//problem 9
public interface Animal {
	abstract void eat();
	default void move() {
		System.out.println("I moved");
	}
}

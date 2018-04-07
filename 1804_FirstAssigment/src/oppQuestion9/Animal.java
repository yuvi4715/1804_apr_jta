package oppQuestion9;

public interface Animal {
	

	public void eat();
	
	public default void move() {
		System.out.println("Animal is walking");
	}

}

    

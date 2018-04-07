package AdvanceConcepts;

public class GarbageCollection {

	public static void main(String[] args) {
		
		GarbageCollection gc = new GarbageCollection();
		gc.add();
	}
	
	public void add() {
		int a = 12;
		int b = 12;
		int z = a + b;
		System.out.println(z);
		System.gc();
	}

}

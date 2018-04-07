package CoreJava;
// Problem 3 - two vars are declared true or false, and then 
// 				are processed based on given statements. Results are returned
public class TrueOrFalse {
	boolean a = true;
	boolean b = false;
	boolean r1;
	boolean r2; 
	boolean r3;
	
	public TrueOrFalse() { // Constructor
		calculate();
		results();
	}
	
	public void calculate() {
		if (!a) {
			r1 = true;
		}
		if (a | b) {
			r2 = true;
		}
		if ((!a & b) | (a & !b)) {
			r3 = true;
		}
	}
	
	public void results() {
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}


	public static void main(String[] args) {
		TrueOrFalse t = new TrueOrFalse();
		
	}
}


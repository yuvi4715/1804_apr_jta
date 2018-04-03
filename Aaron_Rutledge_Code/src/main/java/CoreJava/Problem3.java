package CoreJava;

public class Problem3 {
	
	public boolean a;
	public boolean b;
	
	Problem3 () {
		a = true;
		b = false;
	}
	
	public void outputFuction () {
		
		boolean c = !a;
		
		System.out.println(c);
		
		c = a|b;
		
		System.out.println(c);
		
		c = (!a&b) | (a & !b);
		
		System.out.println(c);
	}

}

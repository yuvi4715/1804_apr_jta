package coreJava;

public class CoreJavaQuestion2 {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		int c = 3;
		int greatest;
		
		if (a > b && a > c)
			greatest = a;
		
		else if (b > a && b > c)
			greatest = b;
		
		else 
			greatest = c;
		
		System.out.println(greatest);
	}
	
	
	
	
		
}

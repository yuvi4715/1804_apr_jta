package Syntax;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		functions calc = new functions();
		
		System.out.println(calc.add(5,4));
		System.out.println(calc.multiply(5,4));
		System.out.println(calc.subtract(5,4));
		System.out.println(calc.divide(100,53));
		

		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		
		if (a>b) {
			System.out.println(" a is bigger than b");
		}else {
			System.out.println(" b is bigger than a");
		}
		
		int numberSwitch =5;
		switch (numberSwitch) {
		case 1:  System.out.println("1");
					break;
		case 2:  System.out.println("2");
					break;
		case 3:  System.out.println("3");
					break;
		case 4:  System.out.println("4");
					break;			
		case 5:  System.out.println("5");
		
		// case 5 will execute if no other casees are used
		
		
		
		
		
		
		
		
		}
		
	}

}

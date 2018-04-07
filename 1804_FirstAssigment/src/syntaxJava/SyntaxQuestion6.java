package syntaxJava;

public class SyntaxQuestion6 {

//	Create an example for each control statement.
	
	public static void main(String[] args) {
		
	//If-else example
	
	int a = 6;
			
	if (a == 100) {
		System.out.println( a + "is equal to 100");
	}
	
	else {
		
		System.out.println(a + " is not equal to 100");
	}

	// Switch-Case example
	
	int b = 67;
	
	switch(b) { 
	case 0: 
			System.out.println("Zero");
	break;

	case 1: 
			System.out.println("One");
	break;
  
	case 2: 
			System.out.println("Two");
	break;
	
	  
	case 3: 
			System.out.println("Three");
	break;
	
	  
	case 4: 
			System.out.println("Four");
	break;
	
	  
	case 5: 
			System.out.println("Five");
	break;
	default:
			System.out.println("Number is greater than 5.");
	
		}
	
	//While-Loop example
	
	int c = 1;
	
	while (c < 1000) { 
		System.out.println(c); 
		c++;
	}
	
	//Do-While Example
	
	int d = 1;
	
	do { 
		System.out.println(d); 
		d++;
	}   while(d < 1000);
	
	//For-Loop example
	
	for (int e = 0; e < 10 ; e++) {
		System.out.println(e); }
	
	//Break example
	
	for (int f = 0; f < 100; f++){ 
		if (f == 6) break; 
		System.out.println(f);
	}
	
	System.out.println("Loop completed.");
	
	//Continue example
	
	for (int g = 0; g < 10; g++){ 
		if (g == 5) continue; 
		System.out.println(g); //Continue jumps system.out
	}

	
  }
	
}


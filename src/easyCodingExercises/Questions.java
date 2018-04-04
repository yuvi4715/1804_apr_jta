package easyCodingExercises;

import java.util.Scanner;

public class Questions {

	public static void main(String[] args) {
		// uncomment a question to run it
		
		//question30();
		//question31();
		//question32();
		//question33();
		  		

	}
	
	
	public static void question30() {
		
		int mark = 60;
		
		if (mark >= 50) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
	}
	
	public static void question31() {
		
		int number= 6;
		
		if( number%2 == 0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
		
	}
	
	public static void question32() {
		
		
		
		int number = 8;			
		
		
		// Using cases
        String wordNumber;
        switch (number) {
            case 1:  wordNumber = "one";
                     break;
            case 2:  wordNumber = "two";
                     break;
            case 3:  wordNumber = "three";
                     break;
            case 4:  wordNumber = "four";
                     break;
            case 5:  wordNumber = "five";
                     break;
            case 6:  wordNumber = "six";
                     break;
            case 7:  wordNumber = "seven";
                     break;
            case 8:  wordNumber = "eight";
                     break;
            case 9:  wordNumber = "nine";
                     break;
            case 10: wordNumber = "ten";
            		 break;
            default: wordNumber = "other";
            
            
                       			 		
	}
        System.out.println(wordNumber);
	
	
}
	
	public static void question33() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input an int");
		int number1 = scan.nextInt();
		
		System.out.println("Please input a double");
		double number2 = scan.nextDouble();
		
		System.out.println("Please input a String");
		String s = scan.next();
		
		System.out.println(number1 +" "+ number2 +" "+s);
		
		
		
		
	}
	
	
}

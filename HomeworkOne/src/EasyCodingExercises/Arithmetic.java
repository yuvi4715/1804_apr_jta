package EasyCodingExercises;

import java.util.Scanner;

public class Arithmetic {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int output = 10; 
        int index2;
        System.out.print("Enter first number ");
        int index = scanner.nextInt();

        System.out.print("Enter second number ");
        index2 = scanner.nextInt();
        
        System.out.print("Enter the operation ");
        String operation = scanner.next();
        if (operation == "+") {
        	output = index + index2;
        } else if (operation == "-") {
        	output = index - index2;
        } else if (operation == "*") {
        	output = index * index2;
        } else if (operation == "/") {
        	output = index / index2;
        }

        

        
        System.out.println("Your result " + output);
    }
}

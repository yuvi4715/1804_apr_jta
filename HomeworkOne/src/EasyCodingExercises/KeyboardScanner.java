package EasyCodingExercises;

import java.util.Scanner;

class KeyboardScanner {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        System.out.print("Enter an int: ");
        int index = scanner.nextInt();

        System.out.print("Enter an double: ");
        double index2 = scanner.nextDouble();

        
        System.out.print("Enter a string: ");
        String sentence = scanner.next();

        System.out.println("\nYour sentence: " + sentence);
        System.out.println("Your int: " + index);
        System.out.println("Your double: " + index2);
    }
}
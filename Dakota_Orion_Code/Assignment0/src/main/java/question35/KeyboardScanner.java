package question35;

import java.util.Scanner;

public class KeyboardScanner {
	
	static void inputReturn() {
		getInt();
		getDouble();
		getString();
	}
	static void getDouble() {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Type a Double");
			double doub = scan.nextDouble();
			System.out.println(doub);
		}
		catch(Exception e) {
			System.out.println("thats not a double");
			getDouble();
		}
	}
	static void getString() {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Type a String");
			String str = scan.nextLine();
			System.out.println(str);
		}
		catch(Exception e) {
			System.out.println("thats not a String");
			getString();
		}
	}
	static void getInt() {
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Type a integer");
			int i = scan.nextInt();
			System.out.println(i);
		}
		catch(Exception e) {
			System.out.println("thats not a integer");
			getInt();
		}
	}
}

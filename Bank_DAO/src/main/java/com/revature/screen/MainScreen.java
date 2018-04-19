package com.revature.screen;

import java.util.Scanner;

//import com.revature.state.ASCIIArt;

public class MainScreen {
	private static Scanner mainInput;

	public static void main (String[] args) {
		System.err.println("Welcome to Bank of Rev!\n");
//		ASCIIArt newScreen = new ASCIIArt();
		
		System.out.println("\n\nEnter 1 for User Login\n" 
		+ "Enter 2 for Admin Login\n" + "Enter 3 for User Registration\n" 
				+ "Enter 4 for Administration Registration\n"
		 + "Enter 5 for FAQ\n" + "Enter 6 for Exit the Software\n" 
		+ "Enter 7 for Forget Username or Password\n" + "Presione el número 8 para instrucción en español\n");
		try {
			mainScreen();
			
		} catch (Exception e) {
			System.out.println("Try again please!");
			main(args);
			
		}
		
	}
	
	public static void mainScreen () {
		System.out.println("1: User Login " 
		+ "2: Admin Login " + "3: User Registration"  
				+ "4: Admin \n"
		 + "5: FAQ " + "6: Exit " 
		+ "7: Forget Username or Password " + "8: instrucción en español\n");

		mainInput = new Scanner(System.in);
		try {
			switch (mainInput.nextInt()) {
				case 1: 
					UserLogin();
					break;
				case 2: 
					AdminLogin();
					break;
				case 3: 
					UserRegister();
					break;
				case 4: 
					AdminRegister();
					break;
				case 5: 
					FAQ();
					break;
				case 6: 
					Exit();
					break;
				case 7: 
					ForgetUserName();
					break;
				case 8: 
					SpanishInstruction();
					break;
				default:
					mainScreen();
					break;
			} 
		} catch (Exception e) {
			System.out.println("Try again please!");
			mainScreen();
		}

		
	}
	
	public static void UserLogin() {
		System.err.println("User Login");
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		Scanner scanner2 = new Scanner(System.in);
		String password = scanner2.nextLine();
		
		// Check if the username and password matches with SQL
		// If yes..
		System.out.println("Hello Blah Blah" + "Your current balance is: Blah Blah");
		System.out.println("Enter 1 if you want to withdraw money\nEnter 2 for deposit money\nEnter any other keys to go back to main menu");
//		scanner3 = new Scanner(System.in)
//		switch (scanner3.nextLine()) {
//			case 1:
//				Deposit();
//				break;
//			case 2:
//				
//		}
			
		// If No...
		System.out.println("Please enter again.");
		UserLogin();
	}
	
	public static void AdminLogin() {
		System.err.println("Admin Login");
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		Scanner scanner2 = new Scanner(System.in);
		String password = scanner2.nextLine();
		
		// store username and password in SQL array

		
		
		// Printout SQL table that APPROVED column = 'N', and ask if that "FIRSTNAME" + "LASTNAME" is approved
		
		
		mainScreen();
	}
	
	public static void UserRegister() {

		System.err.println("User Registration");
		System.out.println("Enter your desired username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Enter your desired password: ");
		Scanner scanner2 = new Scanner(System.in);
		String password = scanner2.nextLine();
		System.out.println("Enter your first name: ");
		Scanner scanner3 = new Scanner(System.in);
		String firstName = scanner3.nextLine();
		System.out.println("Enter your last name: ");
		Scanner scanner4 = new Scanner(System.in);
		String lastName = scanner4.nextLine();
		System.out.println("In case you lose your password, what is the security question to help retrieve it?");
		Scanner scanner5 = new Scanner(System.in);
		String securityQuestion = scanner5.nextLine();
		System.out.println("What is the answer for the security question?");
		Scanner scanner6 = new Scanner(System.in);
		String securityAnwer = scanner6.nextLine();
		
		// Input those string variables into the SQL table
		
		
		
		mainScreen();
	}
	
	public static void AdminRegister() {
		System.err.println("Admin Register");
		System.out.println("Enter your desired username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Enter your desired password: ");
		Scanner scanner2 = new Scanner(System.in);
		String password = scanner2.nextLine();
		System.out.println("Enter your first name: ");
		Scanner scanner3 = new Scanner(System.in);
		String firstName = scanner3.nextLine();
		System.out.println("Enter your last name: ");
		Scanner scanner4 = new Scanner(System.in);
		String lastName = scanner4.nextLine();
		System.out.println("In case you lose your password, what is the security question to help retrieve it?");
		Scanner scanner5 = new Scanner(System.in);
		String securityQuestion = scanner5.nextLine();
		System.out.println("What is the answer for the security question?");
		Scanner scanner6 = new Scanner(System.in);
		String securityAnwer = scanner6.nextLine();
		
		// Input those string variables into the SQL table
		
		
		mainScreen();
	}
	
	public static void FAQ() {
		System.err.println("FAQ");
		System.out.println( 
				"-account creation (admin and user role)\n" + 
				"--admins must approve users before they can be used\n" + 
				"-transactions, must support withdrawals and deposits\n" + 
				"-must use logging\n" + 
				"-everything must NOT be in the main method.\n" + 
				"-data must be persisted\n" + 
				"-collect data inputs from console\n\n");
		System.out.println("Please contact our office for further questions.");
		
		
		mainScreen();
	}
	
	public static void Exit() {

		System.err.println("Exit");
		System.exit(0);		
	}
	
	public static void ForgetUserName() {
		System.err.println("Forget User Name");
		System.out.println("Here is the Security Question");
		System.out.println("What is the answer?");
		
		
		
		mainScreen();
	}
	
	public static void SpanishInstruction() {
		System.err.println("Instrucción en Español");
		System.err.println("Welcome to Bank of Revature!\n");
		System.out.println("Ingrese 1 para inicio de sesión de usuario\n" + 
				"Ingrese 2 para administración\n" + 
				"Ingrese 3 para registrarse como usuario\n" + 
				"Ingrese 4 para el registro de administración\n" + 
				"Ingrese 5 para preguntas frecuentes\n" + 
				"Ingrese 6 para salir del software\n" + 
				"Ingrese 7 para Olvidar el Nombre de Usuario\n");
		try {
			SpanishMainScreen();
			
		} catch (Exception e) {
			System.out.println("Try again please!");
			SpanishInstruction();
			
		}
		
		
		SpanishMainScreen();
	}
	
	public static void SpanishMainScreen () {
		mainInput = new Scanner(System.in);
		try {
			switch (mainInput.nextInt()) {
				case 1: 
					UserLogin();
					break;
				case 2: 
					AdminLogin();
					break;
				case 3: 
					UserRegister();
					break;
				case 4: 
					AdminRegister();
					break;
				case 5: 
					FAQ();
					break;
				case 6: 
					Exit();
					break;
				case 7: 
					ForgetUserName();
					break;
				default:
					SpanishMainScreen();
					break;
			} 
		} catch (Exception e) {
			System.out.println("Por favor, inténtalo de nuevo.");
			SpanishMainScreen();
		}
	}
}

package ranieri.project0;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import ranieri.banque.sqlconnection.*;

import ranieri.banque.sqlconnection.UserService;

public class AdminUI {
	
	
	
	
	public static void adminLoggedIn(User admin) {
		
		Scanner scan = new Scanner(System.in);
		boolean login = true;

		while(login == true) {
			
		System.out.println("Welcome "+ admin.getUsername());		
		
		//System.out.println(customers that need authorization);
		System.out.println("To authorize users type 1");		
		System.out.println("To create an admin type 2");
		System.out.println("To exit type 3");
		
	    String choice = scan.nextLine();	
					
		switch (choice) {
		
		
		case "1": showUnauthUsers();
					break;
		case "2": makeAdmin();
					break;
		case "3": login = false;
					break;
		default: System.out.println("Inavlid input");
					
		
		}
		
		}
			
		
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
	public static void showUnauthUsers() {
		
		Scanner scan = new Scanner(System.in);
		List<String> unath = UserService.getUnAuthUsers();		
		for (String e : unath) {
			System.out.println(e);
		}		
		
		System.out.println("To authorize a user type in the username or enter anything else to exit");
		
		try {
		String username = scan.nextLine();		
		User candidate = UserService.getUser(username);
		candidate.setAuth(1);
		UserService.updateUser(candidate);
		System.out.println("Update successful");
		}catch(Exception e){
			
			System.out.println("exiting without authorizing");
					
		}
		
		
	}
	
	public static void makeAdmin() {

		Scanner scan = new Scanner(System.in);
		System.out.println("To make a user an admin type the username");
		
		try {
		String username = scan.nextLine();		
		User candidate = UserService.getUser(username);
		candidate.setAuth(2);
		UserService.updateUser(candidate);
		System.out.println("New admin created");
		}catch(Exception e){
			
			System.out.println("exiting with creating an admin");
					
		}
		
	}
	
	
	

}

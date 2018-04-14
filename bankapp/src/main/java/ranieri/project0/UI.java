package ranieri.project0;

import java.util.Scanner;

import ranieri.banque.sqlconnection.UserService;

public class UI {
	
public static User customerLoggedIn(User user) {
	
	Scanner scan = new Scanner(System.in);
	boolean loggedIn = true;
	
	// checks for authorization
	
	if (user.getAuth()== 0) {
		System.out.println("You are not authorized at this time");
		return null;
	}
	
	System.out.println("Logged in as "+ user.getUsername() + "       Your current balance: $"+user.getBalance() + "\n" );
	System.out.println("to deposit type  deposit and the ammount   i.e.  deposit 1000");
	System.out.println("to withdrawl type  withdrawl and the ammount   i.e.  withdrawl 1000");
	System.out.println("to logout and finalize changes     logout username");
	
	String[] vars = new String[2];
	
	
	
	while(loggedIn) {
		System.out.println("Logged in as "+ user.getUsername() + "       Your current balance: $"+user.getBalance() + "\n" );	
		String input = scan.nextLine();
		String[] inputs = input.split(" ");
		
		if (inputs.length<2) {
			System.out.println("invalid inputs");
			continue;
		}
				
		if(inputs[0].equals("logout")) {
			
			UserService.updateUser(user);
			System.out.println("logging out and updating your new balance");
			loggedIn = false;
			break;
		}
						
		if(legitInputs(inputs[0],inputs[1])== false) {		
			System.out.println("invalid inputs! ");
			continue;
		}
		
		control(user,inputs[0],Double.parseDouble(inputs[1]));			
		
		System.out.println(inputs[0]+ " "+ inputs[1]+ "  Transaction completed ");
		
		
	}
	
	return user;
		
	}

public static void main(String[] args) {
	
	
	//User adam = new User ("adamd0ggg", "fsdfdsfsdf");
	
	//customerLoggedIn(adam);
	
	//System.out.println(legitNumber("1000"));
	//System.out.println(legitCommand("LOgout"));
	//System.out.println(legitInputs("AdDfdsf", "40"));

	
	
}

public static boolean legitNumber(String num) {
	
	double number = 0;
	
	try {number = Double.parseDouble(num);
		
	}catch(NumberFormatException e){
		
	//System.err.println("Not a valid number");	
	return false;

	}
	
	return true;
}
	

public static boolean legitCommand(String command) {
	
	command = command.toLowerCase();
	
	if( command.equals("withdrawl") ||command.equals("deposit") || command.equals("logout") || command.equals("finalize")) {
		return true;
	}else {
		return false;
	}
	
}


public static boolean legitInputs(String arg1, String arg2) {
	
	if(legitCommand(arg1) && legitNumber(arg2)) {
		return true;
	}
	else return false;
	
	
	
}



public static void control(User user, String s, double num) {
	s = s.toLowerCase();
	
	if(s.equals("deposit")) {
		user.deposit(num);
	}
	if(s.equals("withdrawl")) {
		user.withdraw(num);
	}
	
		
	
	
}


}


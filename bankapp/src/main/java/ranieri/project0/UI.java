package ranieri.project0;

public class UI {
	
public static void customerLoggedIn(String name, double balance) {
	
	boolean loggedIn = true;
	
	System.out.println("Logged in as "+ name+ "       Your current balance: $"+balance + "\n" );
	System.out.println("to deposit type  deposit and the ammount   i.e.  deposit 1000");
	System.out.println("to withdrawl type  withdrawl and the ammount   i.e.  withdrawl 1000");
	System.out.println("to finalize your balance type  finalize  ");
	System.out.println("to logout type     logout");
	
	while(loggedIn) {
		
	}
	
		
	}

public static void main(String[] args) {
	
	//customerLoggedIn("Adam",10000);
	
	//System.out.println(legitNumber("1000"));
	//System.out.println(legitCommand("logout"));
	
	
	
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
	
	if( command.equals("add") ||command.equals("deposit") || command.equals("logout")) {
		return true;
	}else {
		return false;
	}
	
}

}

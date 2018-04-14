package ranieri.project0;

import java.util.Scanner;
import ranieri.banque.sqlconnection.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	boolean appOn = true;
    	while(appOn) {
        greeting();// home page
        
        int choice = validInput();
        if (choice == 0)
        	continue;
    
        switch(choice) {
        
        case 1: login(); 
        		break;
        		
        case 2: createAccount();
        		break;
        
        case 3: appOn= false;
        		break;
        		
        default:System.out.println("Not a valid input \n");
        
        
               
        }
              
    	}
        
    }
    
    public static User makeUser(String name, String password) {   	
    	return new User(name, password);
    	   	
    }
    
    public static void greeting() {
    	System.out.println( "Welcome to Banque du légitimité \n the home of honest banking" );
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to make a new account");
        System.out.println("Press 3 to exit");
        
    }
    
    
    public static void login() {
    	
    	try {
    	System.out.println("Welcome to login please put in username");
    	Scanner scan = new Scanner(System.in);
    	String username = scan.nextLine();
    	User currentUser = UserService.getUser(username);
    	System.out.println("Please verify password");
    	String password = scan.nextLine();
    	
    	
    	if(password.equals(currentUser.getPassword()) && currentUser.getAuth()<2) {    		  		   		
    		UI.customerLoggedIn(currentUser);
    	}
    	if(password.equals(currentUser.getPassword()) && currentUser.getAuth()>1) {    		  		   		
    		AdminUI.adminLoggedIn(currentUser);
    	}
    		
    	else {
    		System.out.println("Incorrect username or password");
    	}
    	}catch(Exception e) {
    		System.out.println("Invalid inputs");  		
    	
    	}
    
    	
    }
    
    public static void createAccount() {
    	
    }
    
    public static int validInput() {
    	 
    	Scanner scan = new Scanner(System.in);
        try {
        int choice = scan.nextInt();
        return choice;
        }catch(Exception e){
        	System.out.println("Not a valid input!!!!");
        }
        return 0;
    	
    }
    
    
}

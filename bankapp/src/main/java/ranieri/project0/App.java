package ranieri.project0;

import java.util.Scanner;

import org.apache.log4j.Logger;

import ranieri.banque.sqlconnection.*;
import ranieri.logger.Logger4j;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Logger log = Logger.getLogger(Logger4j.class);
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
        		
        case 2: createUser();
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
        System.out.println("Press 2 to make a new user account");
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
    		final Logger log = Logger.getLogger(Logger4j.class);
        	log.info("user "+ currentUser.getUsername()+" logged in");
    		UI.customerLoggedIn(currentUser);
    		log.info("user "+ currentUser.getUsername()+" logged out");
    	}
    	if(password.equals(currentUser.getPassword()) && currentUser.getAuth()>1) { 
    		final Logger log = Logger.getLogger(Logger4j.class);
    		log.info("user "+ currentUser.getUsername()+" logged in");
    		AdminUI.adminLoggedIn(currentUser);
    		log.info("user "+ currentUser.getUsername()+" logged out");
    		
    	}
    		
    	else {
    		System.out.println("Incorrect username or password");
    	}
    	}catch(Exception e) {
    		System.out.println("Invalid inputs");  		
    	
    	}
    
    	
    }
    
    public static void createUser() {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	try {
    	System.out.println("please enter a username with no spaces");
    	String username = scan.nextLine();
    	username = username.trim();
    	
    	System.out.println("please enter a password with no spaces");
    	String password = scan.nextLine();
    	password = password.trim();
    	
    	User new_user = new User(username,password);
    	  	
    	UserService.insertUser(new_user);
    	System.out.println("Succesfully created a new user");
    	final Logger log = Logger.getLogger(Logger4j.class);
    	log.info("A new user " +new_user.getUsername()+" was created");
    	
    	}catch (Exception e) {
    		System.out.println("Invalid inputs");
    	}
    	
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

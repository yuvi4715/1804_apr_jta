package ranieri.project0;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Banque du légitimité \n the home of honest banking" );
        System.out.println("Press 1 for login and 2 to create a new login");
        System.out.println("Please enter your Username and password" );
        
        
        
        
        
        
        
        
        
        
    }
    
    public static Customer makeUser(String name, String password) {   	
    	return new Customer(name, password);
    	   	
    }
    
    
    
    
    
}

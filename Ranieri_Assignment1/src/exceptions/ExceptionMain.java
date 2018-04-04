package exceptions;

public class ExceptionMain {
	
	
	public static void main(String[] args) {
		try {
			terribleFunction();
		} 
		catch(RanieriEx r){
			
			System.out.println("caught the exception in the main class");
			r.getMessage();
		//	System.exit(0);
		} catch(Exception e) {
			
			System.out.println("caught in second catch");
			e.getMessage();
			
		}
		finally {
			System.out.println("we are in the always executing final block except if system ends in the catch");
		}
		
		
	}
	
	
	public static void terribleFunction() throws RanieriEx {
		
		System.out.println("Inside a terrible funtion that only throws an exception");	
		throw new RanieriEx();
		
	}
	
	

}

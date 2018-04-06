package exceptions;
/*
 *  problems 12 through 15
 *  12 - prints are placed to check where and when code is run.
 *  13 - using throws to duck the exception
 *  14 - indicates the creation of a final block, with output of graceful send off
 *  15 - uses System.exit(0) in the try block to note results
 */
public class ManualExceptions2 {
	public ManualExceptions2() {
		super();
	}
	
	void doSomething() throws OverridingGetMessage {
		String topic = null;
		if (topic == null) {
			throw new OverridingGetMessage();
		}
	}
	
	public static void main(String[] args) throws OverridingGetMessage{
		try { 
			System.out.println("Try block start"); // 12 outputs to note operation
			new ManualExceptions2().doSomething();
			System.exit(0);  // 15. the finally block still runs, suggesting an exception from it.
		} catch (Exception a) {
			System.out.println("This exception was ducked"); //13. exception was ducked
			System.out.println("Try block ended, catch block start");
			System.out.println("catch block ended");
			
			
		// 14. finally block implemented, with a nice send off.	
		} finally { 
			
			System.out.println("Sorry for all of the noise. Have a good day.");
			
		}
		
		
	}
	
}
	

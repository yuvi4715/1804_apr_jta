package ranieri.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Logger4j {

	
	

	final static Logger log = Logger.getLogger(Logger4j.class);
	
	static boolean b;
	public static void main(String[] args) {
		System.out.println("logging");
		BasicConfigurator.configure();
		
		log.info("Info should be printed");		
		log.warn("warning should be printed yo");
		log.error("error should be printed does not compute");
		log.debug("debug should be printed less buggy");
		new Logger4j().verifyExceptions();
		
		System.out.println(b);
		
		
		}
	
	@SuppressWarnings("Unused")	
	public void verifyExceptions() {
		if (10==20) {
			log.error("What are you talking about");
		}else {
			log.info("its not cool!!!");
		}
	

}
}

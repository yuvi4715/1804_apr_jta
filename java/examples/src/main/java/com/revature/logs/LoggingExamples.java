package com.revature.logs;

import org.apache.log4j.Logger;

public class LoggingExamples {

	final static Logger log = Logger.getLogger(LoggingExamples.class);
	
	public static void main(String[] args) {
		//System.out.println("logging");
		log.info("info should be printed");
		log.warn("warning should be printed");
		log.error("error should be printed");
		log.debug("debug should be printed");
		new LoggingExamples().verifyExceptions();
	}
	
	@SuppressWarnings("unused")
	public void verifyExceptions() {
		if (10 == 20) 
			log.error("what? are you talking about? ");
		 else 
			log.info("its not cool!!!");
	}

}

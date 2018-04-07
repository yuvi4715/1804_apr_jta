package com.revature.logging;

import org.apache.log4j.Logger;
//log file location defined in log4j properties
public class LoggingExample {
	final static Logger logger =Logger.getLogger(LoggingExample.class);
	public static void main(String[] args) {
		//System.out.println("logging");
		logger.info("new info should be printed");
		logger.warn("info should be printed");
		logger.error("info should be printed");
		logger.debug("info should be printed");
		new LoggingExample().verifyExceptions();
		
	}

	public void verifyExceptions() {
		if(10 == 20)
			logger.error("error message");
		else logger.info("else of error");
	}
}

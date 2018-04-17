package joey.bank;

import org.apache.log4j.Logger;

/**
 * The Log class wraps log4j to log all desired footprints left by BankApp. 
 * Log file location defined in log4j properties.
 * @author joeyi
 *
 */
public class Log {
	
	// .class gets an instance of the Log class at run time
	final static Logger BankLog = Logger.getLogger(Log.class);
	
	//Instantiate log by logging start
	public Log()
	{
		BankLog.info("Start of BankLog");
	}
	
	//Method to log errors only
	public static void logError(String msg) 
	{
		BankLog.error(msg);
	}
	
	//Method to log info
	public static void logInfo(String msg)
	{
		BankLog.info(msg);
	}

}
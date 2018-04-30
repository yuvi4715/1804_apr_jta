package dev;

import org.apache.log4j.Logger;

/**
 * The Log class wraps log4j to log all desired footprints left by ReimbursementApp. 
 * Log file location defined in log4j properties.
 * @author joeyi
 *
 */
public final class Log {
	
	// .class gets an instance of the Log class at run time
	public final static Logger Log = Logger.getLogger(Log.class);
	
	//Instantiate log by logging start
	public Log()
	{
		Log.info("Start of new session");
	}
	
	//Method to log errors only
	public static void fatal(String msg) 
	{
		Log.fatal(msg);
	}
	
	public static void warn(String msg)
	{
		Log.warn(msg);
	}
	//Method to log debugging notes
	public static void debug(String msg)
	{
		Log.error(msg);
	}
	
	//for user errors
	public static void userError(String msg)
	{
		Log.info(msg);
	}

}
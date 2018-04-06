package Exceptions;

public class MyException extends Exception
{
	public MyException(String message)
	{
		super(message);
	}
	public String getMessage()
	{
		return "Help!";
	}
}

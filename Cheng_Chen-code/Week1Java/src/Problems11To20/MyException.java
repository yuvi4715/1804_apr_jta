package Problems11To20;

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

package exceptions;

public class CustomException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1997069109076644065L;
	
		public String getMessage()
		{
			return "Ah!Ah!AH! You didn't say the 'Magic Word!'";
		}

}

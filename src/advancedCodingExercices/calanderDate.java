package advancedCodingExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 39
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

public class calanderDate
{

	public static void main(String[] args)
	{
		Calendar birthday = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int result = 0;
		birthday.set(2018, 4, 6);
		today.set(2018, 4,6);
		result = birthday.compareTo(today);
		if(result != 0)
		{
			System.out.println("Today is not your birthday! ");
		}
		else
		{
			System.out.println("Happy Birhtday to you CHA CHA CHA "
					+ "Happy Birhtday to you CHA CHA CHA "
					+ "Happy Brihday Dear YOU  Happy Birthday to you!!! ");
		}


	}

}

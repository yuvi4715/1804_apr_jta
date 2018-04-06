import java.util.*;

public class problem39 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int month = 0, day = 0, year = 0;
		System.out.println("Please enter your birth month: ");
		if(in.hasNextInt())
			month = in.nextInt();
		
		System.out.println("Please enter your birth day: ");
		if(in.hasNextInt())
			day = in.nextInt();
		
		System.out.println("Please enter your birth year: ");
		if(in.hasNextInt())
			year = in.nextInt();
		 
		Calendar today = new GregorianCalendar();
		Calendar birthdayCal = new GregorianCalendar(year,month,day);
		Date today2 = today.getTime(); 
		boolean birthday = (today2.getDay() + 1 == day) && (today2.getMonth() + 1 == month);
		int age=today2.getYear()-birthdayCal.getTime().getYear();
		System.out.println(age);
		
		if(birthday)
		{
			System.out.println("Happy Birthday to you!");
			System.out.println("Happy Birthday to you!");
			System.out.println("Happy Birthday dear one!");
			System.out.println("Happy Birthday to you!");
			

			System.out.println("From good friends and true,");
			System.out.println("From old friends and new,");
			System.out.println("May good luck go with you,");
			System.out.println("And happiness too.");
		}
			
	}

}

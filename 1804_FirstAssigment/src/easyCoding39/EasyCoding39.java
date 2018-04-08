package easyCoding39;

import java.util.Calendar;

//Write a method that takes a date of birth via Calendar object and returns your age. 
//If it is your birthday, print the Happy Birthday song!

public class EasyCoding39 
{

		public static void main(String[] args) 
		{
			String age = getAge(1989, 10, 13);
			System.out.println("Your age is: " + age);
		}
		
		public static void HappyBirthdaySong(){
			System.out.println("¡Cumpleaños feliz, cumpleaños feliz" +
						", cumpleaños, amigo, cumpleaños feliz!");
		}
		
		public static String getAge(int year, int month, int day) 
		{
			Calendar calendar = Calendar.getInstance();
			boolean bd = false;
			
			if ((month == calendar.get(Calendar.MONTH) + 1) && (day == calendar.get(Calendar.DAY_OF_MONTH)));
			{
				HappyBirthdaySong();
				bd = true;
			}
			
			long currentTime = calendar.getTimeInMillis();

			calendar.set(year, month, day);
			long birthDate = calendar.getTimeInMillis();
			long age = currentTime - birthDate;
			calendar.setTimeInMillis(age);
			int years = calendar.get(Calendar.YEAR) - 1970;
			int months = calendar.get(Calendar.MONTH) + 1; 
			int days = calendar.get(Calendar.DAY_OF_MONTH);
			
			if (bd) 
			{
				years++;
				months = 0;
				days = 0;
			}
			String ageString = years + " years, " + months + " months, " + days + " days.";
			
			return ageString;
		}
}


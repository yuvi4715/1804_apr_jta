package advancedCodingExcercises;

import java.util.Calendar;

// 36 a program that uses methods to determine age and if it is your birthday(hardcoded), if it is your birthday
// the birthday song is printed out
public class Birthday {
	
	String Name;
	Calendar day = Calendar.getInstance();
	Calendar bDay = Calendar.getInstance();
	
	public Birthday() {
		Name = "Michael";
		setBirthday();
		getDate();
		getBirthday();
		getAge();
		
	}
	
	void getBirthday() { // if true the birthday song is printed
		if (isBirthDay() == true) {
			System.out.println("Happy birthday to you!");
			System.out.println("Happy birthday to you!");
			System.out.println("Happy birthday dear " + Name);
			System.out.println("Happy birthday to you!");
		}
	}
	
	void setBirthday() {
		bDay.set(Calendar.MONTH, 7);
		bDay.set(Calendar.DATE, 1);
		bDay.set(Calendar.YEAR, 1993);
	}
	
	void getDate() {
		day.set(Calendar.MONTH, 7);
		day.set(Calendar.DATE, 1);
		day.set(Calendar.YEAR, 2018);
	}
	
	void getAge() {
		int yearCurrent = day.get(Calendar.YEAR);
		int yearBirth = bDay.get(Calendar.YEAR);
		System.out.println("You are now: " +  (yearCurrent - yearBirth));
	}
	
	boolean isBirthDay() {
		boolean isBDay = false;
		int dayMonth = day.get(Calendar.MONTH);
		int bDayMonth = bDay.get(Calendar.MONTH);
		int date = day.get(Calendar.DATE);
		int bDate = bDay.get(Calendar.DATE);
		

		if (dayMonth == bDayMonth && date == bDate) {
			System.out.println("It is your birthday!");
			isBDay = true;

		}
				
		return isBDay;
	}
	
	public static void main(String[] args) {
		Birthday t = new Birthday();
		
	}
}

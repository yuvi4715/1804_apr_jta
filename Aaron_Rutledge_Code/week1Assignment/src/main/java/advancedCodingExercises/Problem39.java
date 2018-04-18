package advancedCodingExercises;

import java.util.Calendar;
import java.time.LocalDate;


public class Problem39 {
	
	
	public static void main(String[] args) {
		
		
		
		Calendar bday = Calendar.getInstance();
		
		bday.set(2018, 3, 5);
		
		System.out.println(getAge(bday));
		
		
		
		
	
	
	
	
	}
	
	
	public static int getAge(Calendar bday) {
		
		LocalDate today = LocalDate.now();
		
		int x = today.getYear();
		int y = bday.get(Calendar.YEAR);
		
		int age = x - y;
		
		
		
		x = today.getDayOfYear();
		y = bday.get(Calendar.DAY_OF_YEAR);
		
		//System.out.println("x: " + x + ", y: " + y);
		
		
		if (x < y) {
			age = age - 1;
			
		}
		
		if (((today.getYear() % 4) == 0) && (today.getDayOfYear() >= 50)) {
			x = x-1;
		}
		if (((bday.get(Calendar.YEAR) % 4) == 0) && (bday.get(Calendar.DAY_OF_YEAR) >= 50)) {
			y = y-1;
		}
		
		
		if (x == y) {
			System.out.println("HAPPY BIRTHDAY!");
		}
		
		return age;
		
		
	}
	
	
	
	
	

}

package question39;

import java.time.LocalDateTime;
import java.util.Calendar;

public class q39 {
	public static void main(String[] args) {
		int year= 1994;
		int month=2;
		int day=5;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		new q39().findAge(cal);
	}
	
	public void findAge(Calendar cal) {
		int y = cal.get(Calendar.YEAR);
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH);
		LocalDateTime now = LocalDateTime.now();
		int hadBirthdayThisYear=0;
		int curYear=now.getYear();
		int curDay=now.getDayOfMonth();
		int curMonth= now.getMonthValue()-1;
		if(curMonth==m) {
			if(d==curDay) {
				System.out.println("HAPPY BIRTHDAY!!");
				hadBirthdayThisYear=1;
			}
			else {
				if(d<curDay) {
					hadBirthdayThisYear=1;
				}
			}
		}
		if(curMonth>m) {
			hadBirthdayThisYear=1;
		}
		System.out.println("You are " + (hadBirthdayThisYear+curYear-y) +" years old");
	}

}

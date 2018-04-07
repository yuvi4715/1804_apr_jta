package assignment.Joey.AdvancedCodingPrograms;

import java.util.Calendar;

/**2. Write a method that takes a date of birth via Calendar object and 
 * returns your age. 
 * If it is your birthday, print the Happy Birthday song!
8. Write a method to determine if a number is prime. 

 
 * Sign up for insurance, 
 * 
 * 
 * 
*/
public class Birthday{
	//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Calendar current= Calendar.getInstance();


	public static void main(String[] args) {
		Calendar r = Calendar.getInstance();
		//if birthday is 1993, 03, 07 => April 7
		r.set(2017, 3, 27); //03 for april
		calcAge(r);
		r.set(2016, 3, 7);
		calcAge(r);
		r.set(2016, 3,8);
		
		calcAge(r);
	}

	public static void calcAge(Calendar c) {
		//birthday has not passed
		int currentMonth=current.get(Calendar.MONTH);
		int currentDate=current.get(Calendar.DATE);
		int bMonth=c.get(Calendar.MONTH);
		int bDate=c.get(Calendar.DATE);
		int monthOld=currentMonth-bMonth; //default case when birthday has passed
		int dayOld=currentDate-bDate;
		int y=current.get(Calendar.YEAR)-c.get(Calendar.YEAR);
		//case when birthday
		if (currentMonth==bMonth && currentDate==bDate)
		{
			System.out.println("This is the Happy Birthday Song: Happy Birthday to you...");
			monthOld=0;
			dayOld=0;
		}
		//bithday month, but not birthday yet
		if(currentMonth==bMonth && currentDate<bDate)
		{
			y-=1; //age has not increased yet
			monthOld=11; 
			{	//day until birthday
				int dateT=Math.abs(currentDate-bDate);
			//days until birthday, ex if 1 day til bday, then you're daymonth-1 day old
				dayOld=c.getActualMaximum(Calendar.DAY_OF_MONTH)-dateT;
			}
		} 
		
		if(currentMonth<bMonth)//bithday month not here yet
		{
			y-=1;
			monthOld=currentMonth;
			
			
		}
		/**
		int m=c.get(Calendar.MONTH)-current.get(Calendar.MONTH);;
		int d=c.get(Calendar.DATE)-current.get(Calendar.DATE);; //if in birthday month, check is date has passed
		
		if()
		
		if(current.get(Calendar.MONTH)>c.get(Calendar.MONTH))
		//if current month is larger than birthday month, then birthday already passed
		{
			m=current.get(Calendar.MONTH)-c.get(Calendar.MONTH);
		} else if(current.get(Calendar.MONTH)==c.get(Calendar.MONTH)) 
		  {     //birthday month
			   m=11;
			   if(current.get(Calendar.DATE)>c.get(Calendar.DATE))
			   { //birthday passed
				   d=current.get(Calendar.DATE)-c.get(Calendar.DATE);
				   m=0;
			   } else if(current.get(Calendar.MONTH)==c.get(Calendar.MONTH))
			  {//bithday, month count returns to 0
				   m=0;
					System.out.println("This is the Happy Birthday Song");
					d=0;
			  }
			
		} else if (current.get(Calendar.MONTH)<c.get(Calendar.MONTH)) {
			y-=1; //age decrease 1	
		}
			  
		//birthday month has not passed
		// if current month is less than birthday month, then age-1
	*/
		if (c.before(current)) { 
			System.out.println("You're "+ y +
					" years "+ monthOld +
					" months and " +dayOld
							+ " days old");
		}else System.out.println("date is out of range");
		
	}
	

}

package com.revature.Homework.ProblemThirtyNine;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {		
		 Scanner in = new Scanner(System.in);
		 int year = 0, month = 0, day = 0;
		 System.out.println("Please Enter Year: ");
		 if(in.hasNextInt())
			 year = in.nextInt();
		 System.out.println("Please Enter Month: ");
		 if(in.hasNextInt())
			 month = in.nextInt();
		 System.out.println("Please Enter Day: ");
		 if(in.hasNextInt())
			 day = in.nextInt();
		 Calendar todayCal = new GregorianCalendar();
		 Calendar birthdayCal = new GregorianCalendar(year,month,day);
		 Date todayDate = todayCal.getTime(); 
		 boolean birthday=todayDate.getDay()+1==day&&todayDate.getMonth()+1==month;
		 int diff=todayDate.getYear()-birthdayCal.getTime().getYear();
		 System.out.println(diff);
		 if(birthday)
			 System.out.println("Happy Birthday");
	 }
}

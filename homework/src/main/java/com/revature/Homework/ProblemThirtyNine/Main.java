package com.revature.Homework.ProblemThirtyNine;


import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {		
		 test01(System.out);
	 }
	 public static void test01(PrintStream out){
		 Scanner in = new Scanner(System.in);
		 int year = 0, month = 0, day = 0;
		 out.println("Please Enter Year: ");
		 if(in.hasNextInt())
			 year = in.nextInt();
		 out.println("Please Enter Month: ");
		 if(in.hasNextInt())
			 month = in.nextInt();
		 out.println("Please Enter Day: ");
		 if(in.hasNextInt())
			 day = in.nextInt();
		 Calendar todayCal = new GregorianCalendar();
		 Calendar birthdayCal = new GregorianCalendar(year,month,day);
		 Date todayDate = todayCal.getTime(); 
		 boolean birthday=todayDate.getDay()+1==day&&todayDate.getMonth()+1==month;
		 int diff=todayDate.getYear()-birthdayCal.getTime().getYear();
		 out.println(diff);
		 if(birthday)
			 out.println("Happy Birthday");
	 }
}

package com.revature.advancecoding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class AdvanceCoding {

	public static void main(String[] args) throws ParseException {
		AdvanceCoding ac = new AdvanceCoding();
		ac.stringReplace();
		ac.Age();
		ac.print50();
		ac.ReverseString();
		ac.primeOrNot(3);
		ac.Armstrong(153);
		
		for (int i = 0; i <= 100; i++) {
			System.out.println("Fib Result "+ i + " is " + fibonacci(i));
		}
		
		
		
	}
	
		public void stringReplace() {
			String s = "Hello Everyone";
			System.out.println("Before Replacing : " + s);
			System.out.println("After Replacing : \n" + s.replace("o", "O"));
		}

		public void Age() throws ParseException {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter date of birth in YYYY-MM-DD: ");
			String birth = scan.nextLine();
			scan.close();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dob = Calendar.getInstance();
			dob.setTime(sdf.parse(birth));
			
			Calendar now = Calendar.getInstance();
			 int dobyear = dob.get(Calendar.YEAR);
			 int curryear = now.get(Calendar.YEAR);
			 int age = curryear - dobyear; 
			System.out.println("\nAge is:" + age);
			
			
			
			if(dob.get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
				
				if(dob.get(Calendar.DATE) == now.get(Calendar.DATE)) {
					System.out.println("Happy Birthday...");
				}				
			}			
		}
		
		public static int fibonacci(int n)  {
		    if(n == 0)
		        return 0;
		    else if(n == 1)
		      return 1;
		   else
		      return fibonacci(n - 1) + fibonacci(n - 2);
		}
		
		public void print50() {
			System.out.println("\nPrinting 1 to 50:");
			for (int i = 0; i < 51; i++) {
				if((i%15) == 0) {
					System.out.println("FizzBizz");
				}
				else if((i%5) == 0) {
					System.out.println("Bizz");
				}
				else if ((i%3) == 0) {
					System.out.println("Fizz"); 
				}
				else {
					System.out.println(i);
				}
			}
		}
		
		public void ReverseString() {
			String s = "alab";
			StringBuffer sb = new StringBuffer();
			for(int i = s.length() - 1;i>=0;i--) {
				sb.append(s.charAt(i));
			}
			System.out.println("\nReverse String");
			System.out.println(sb.toString());
		}
		
		public void primeOrNot(int a) {
			boolean isPrime=true;
			
			for(int i=2;i<=a/2;i++)
			{
		      if(a%i == 0)
			   {
			      isPrime=false;
			      break;
			   }
			}
			if(isPrime)
			   System.out.println(a + " is a Prime Number");
			else
			   System.out.println(a + " is not a Prime Number");
			   }
		
		public void Armstrong(int n) {
			int a ,b,c;
			
			a = n/100;
			b = (n/10)%10;
			c = n %10;
			if(n == ((a*a*a)+(b*b*b)+(c*c*c))) {
				System.out.println(n + " is a Armstrong Number");
			}else {
				System.out.println(n + " is not a Armstrong Number");
			}
		}
}

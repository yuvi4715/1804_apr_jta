package advanced.coding;

import java.util.Calendar;
import java.util.Comparator;

import file.io.Employee;

public class Questions {
	
	public static void main(String[] args) {
		
	//	question38("wooow woow jowk kol",'w','m');
	//	question39();
	//	System.out.println(question40(8));
	//	question41();
	//	question43(120);
	//	question45(97);
	//	question44(" what would you do for a klondike bar?");
		
	}
	
	public static void question38(String s, char oldChar, char newChar ) {
		
		System.out.println(s.replace(oldChar, newChar));
	}
	
	public static void question39() {
		
		Calendar bday = Calendar.getInstance();
		bday.set(1994, 5, 20);
		Calendar today = Calendar.getInstance();
		
		int time = bday.compareTo(today);
		
		double difference = today.getTimeInMillis()- bday.getTimeInMillis();
		System.out.println( "This many years old"+ difference/1000/60/60/24/365);
		
		
		

		int monthB = bday.get(Calendar.MONTH);
		int dayB = bday.get(Calendar.DAY_OF_MONTH);
		

		int monthT = bday.get(Calendar.MONTH);
		int dayT = bday.get(Calendar.DAY_OF_MONTH);
		
		if(monthT == monthB && dayT == dayB) {
			System.out.println("Happy birthday");
			
		}
		
		
	}
	
	public static int question40(int x) {
		
		// base cases
		if (x <=2) {
			return 1;
		}
		if (x ==0) {
			return 0;
		}
		
		int answer = question40(x - 1) + question40(x - 2);
		
		return answer;
		
		
	}
	
	public static void question41() {
		
		for (int i =0; i<51; i++) {
			
			if (i%3 ==0 && i%5 == 0) {
				System.out.println("FizzBuzz");
				continue;
			}						
			
			if (i%3 == 0){
				System.out.println("Fizz");
				continue;
			}
			
			if (i%5 == 0){
				System.out.println("Buzz");
				continue;
			}else {
				System.out.println(i);
			}
			
			
			
			
			
		}
		
	}
	
	public static void question42() {
		
		// is in the collection package java
		
	}
	
	public static void question43(int n) {
		// I copied this method and modified it to make it dynamic
		int b =0;
		int a;
		int c = n;
		
		
		
	    while(n>0){
	              a=n%10;  n=n/10;  b=b+(a*a*a);
	              System.out.println(a+"  "+n+"  "+b);  
	            }
	    if(c==b)  System.out.println("Armstrong number");
	    else      System.out.println(" Not Armstrong number");
	    }
	
	public static String question44(String s) {
		
		//String s = "hello world";		
		String backwards = "";
        
        
        for(int i = s.length() - 1; i >= 0; i--) {
        	
            backwards = backwards + s.charAt(i);          
        }
        
        return backwards;
		//System.out.println(backwards);
	}
		
	public static String question45(int n) {
		
		
		for(int i = 2;i< n/2; i++ ) {
			
			if (n%i == 0) {
				System.out.println("Not Prime");
				return "";
			}			
			
		}
		System.out.println("Is prime");
		return"";
	}
	

}


class employeeSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int result = o1.getLastName().compareTo(o2.getLastName());
		if (result != 0 ) {			
			return result;
		}
		
		return o1.getLastName().compareTo(o2.getLastName());
	}
}






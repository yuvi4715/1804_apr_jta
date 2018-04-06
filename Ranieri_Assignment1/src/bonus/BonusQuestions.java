package bonus;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import advanced.coding.Questions;
import advanced.coding.Questions.*;


public class BonusQuestions {

	public static void main(String[] args) {
		
	//	question57("wow");
	//	question49();
	//	question56();
	//    question61(); do not use
		
		
	}
	
	
	public static void question57(String s) {
		
		if (s.equals(Questions.question44(s)))
			System.out.println("is a palindrone");
		else
			System.out.println("Not a palindrone");
	}
	
	public static void  question49() {
		
		String s = "Lets go gators!";
		
		System.out.println(s.substring(5));
	}
	
	public static void question56() {
		
		double a =1910;
		
		if (a/2 - ((int)a)/2 ==0) {
			System.out.println("It is even");
		}else {			
			System.out.println("It is odd");
		}
		
		
		
		
		
		
		
	}
	
	public static void question61() {
		// currently broken do not use
		int array[] = {1,2,3,4,4,4,5,5,6,7,8,9};
		
		Set uniqueNums = new TreeSet();
		
		uniqueNums.addAll(Arrays.asList(array));
		System.out.println( uniqueNums);
		
		
		
		
		
		
		
	}
	
}

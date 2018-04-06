package Bonus;

public class Problem56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String isP = "racecar";
		String notP = "Blargh";
		
		if(isPalindrome(isP))
			System.out.println(isP + " is a palindrome.");
		else
			System.out.println(isP + " is not a palindrome.");
		
		if(isPalindrome(notP))
			System.out.println(notP + " is a palindrome.");
		else
			System.out.println(notP + " is not a palindrome.");
	}
	
	public static boolean isPalindrome(String s) 
	{
	    return s.equals(new StringBuilder(s).reverse().toString());
	}
}

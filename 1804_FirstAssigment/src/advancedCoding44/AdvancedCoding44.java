package advancedCoding44;

//Write a method to reverse a String without using API functions.


public class AdvancedCoding44 
{
	public static void main(String[] args) 
	{
		
		 String Reversed ="Reversed String";

			 for(int i=0;i<=Reversed.length()-1;i++)
			 {
			     System.out.print(Reversed.charAt(i));
			 }
			     System.out.println("");

			 for(int i = Reversed.length() - 1; i >= 0; --i)
			 {
			     System.out.print(Reversed.charAt(i)); 
			 }
		
		
	}
}


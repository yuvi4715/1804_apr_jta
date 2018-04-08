package easyCoding38;

//Write a method to replace a given character in a String with another character.


public class advancedCoding 
{

		public static void main(String[] args) 
		{
			String example = "Dragonball Z";
			char oldChar = 'b';
			char newChar = 'f';
			
			System.out.println("Base word: " + example);
			example = replaceChar(oldChar, example, newChar);
			System.out.println("Modified word: " + example);
		}
		public static String replaceChar(char oldChar, String str, char newChar) 
		{
			return str.replace(oldChar, newChar);
		}
}
	


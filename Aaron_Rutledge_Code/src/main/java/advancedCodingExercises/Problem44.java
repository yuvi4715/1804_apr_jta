package advancedCodingExercises;

public class Problem44 {
	
	public static void main(String[] args) {
		
		
		System.out.println(reverseString("This is not a palindrome."));
		
		
	}
	
	
	public static String reverseString(String str) {
		
		int indexIn = str.length();
		int temp = indexIn;
		
		char [] charAryIn = str.toCharArray();
		char [] charAryOut = new char[temp];
		
		temp--;
		
		for (int i = 0; i < indexIn; i++) {
			
			
			
			charAryOut[i] = charAryIn[temp];
			
			temp--;
			
			
		}
		
		str = new String(charAryOut);
		
		return str;
	}
	
	

}

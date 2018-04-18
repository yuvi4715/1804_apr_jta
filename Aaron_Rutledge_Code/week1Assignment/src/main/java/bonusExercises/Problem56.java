package bonusExercises;

public class Problem56 {
	
	
	public static void main(String[] args) {
		
		
		System.out.println(isPalindrome("kek"));
		
	}
	
	
	
	public static boolean isPalindrome(String str) {
		
		char [] cAry = str.toCharArray();
		int x = str.length();
		
		
		for (int i = 0; i < x; i++) {
			
			if(cAry[i] != cAry[x-1-i]) {
				
				return false;
				
			}
			
			
			
		}
		
		
		
		return true;
		
	}

}

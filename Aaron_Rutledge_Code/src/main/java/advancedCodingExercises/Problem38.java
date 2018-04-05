package advancedCodingExercises;

public class Problem38 {
	
	public static String replaceCharacterInString(String str, int position, char c) {
		
		char [] charAry = str.toCharArray();
		
		charAry[position] = c;
		
		String returnStr = new String(charAry);
		
		return returnStr;
		
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(replaceCharacterInString("Spring", 1, 't'));
		
	}
	

}

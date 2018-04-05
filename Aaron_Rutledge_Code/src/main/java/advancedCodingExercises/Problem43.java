package advancedCodingExercises;

public class Problem43 {
	
	//An Armstrong number of three digits is an integer such that the sum of 
	//the cubes of its digits is equal to the number itself. 
	//For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
	
	public static void main(String[] args) {
		
		
		System.out.println(isArmstrong(407));
		
		
		
	}
	
	
	public static boolean isArmstrong(int num) {
		
		
		Integer target = num;
		
		String str = target.toString();
		
		
		
		num = str.length();
		
		int sum = 0;
		int tempInt = 0;
		
		
		char [] charArray = str.toCharArray();
		
		for (int i = 0; i < num; i ++) {
			
			
			tempInt = charArray[i] - 48;
			//System.out.println("Digit: " + tempInt);
			
			tempInt = tempInt * tempInt * tempInt;
			
			//System.out.println("Cube: " + tempInt);
			
			sum = sum + tempInt;
					
			//System.out.println("Sum: " + sum);
			
			
		}
		
		if (target.intValue() == sum) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
	

}

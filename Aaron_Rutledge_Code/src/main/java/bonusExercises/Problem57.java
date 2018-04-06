package bonusExercises;

public class Problem57 {
	
	public static void main(String[] args) {
		
		int [] testAry = {15, 35, 12, 9, 7};
		
		
		testAry = sortArray(testAry);
		
		for(int i : testAry) {
			
			System.out.println(i);
		}
		
		
		
		
	}
	
	
	
	public static int[] sortArray(int[] intAry) {
		
		boolean sorted = false;
		boolean changeMade = false;
		int temp = 0;
		int sizeAdjusted = intAry.length - 1;
		
		while (!sorted) {
			
			for(int i = 0; i < sizeAdjusted; i++) {
				
				if(intAry[i] > intAry[i+1]) {
					
					temp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = temp;
					changeMade = true;
				}
				
			}
			if(!changeMade) {
				sorted = true;
			} else {
				
				changeMade = false;
			}
			
			
		}
		
		return intAry;
		
		
	}
	

}



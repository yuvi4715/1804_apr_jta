package bonusExercises;

public class Problem46 {
	
	
	public static void main(String[] args) {
		
		swapInt(15,30);
		
		
	}
	
	
	
	
	
	
	public static void swapInt(int arg0, int arg1) {
		
		System.out.println("arg0: " + arg0 + ", arg1: " + arg1);
		
		arg0 = arg1 + arg0;
		
		arg1 = arg1 - arg0;
		
		arg0 = arg0 + arg1;
		
		arg1= -1*arg1; 

		System.out.println("arg0: " + arg0 + ", arg1: " + arg1);
		
	}

}

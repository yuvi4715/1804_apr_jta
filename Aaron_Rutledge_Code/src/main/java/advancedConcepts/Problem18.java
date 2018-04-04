package advancedConcepts;

public class Problem18 {
	
	public static void main(String[] args) {
		String numStr1 = new String("20");
		String numStr2 = new String("5");
		
		int num1 = Integer.parseInt(numStr1);
		int num2 = Integer.parseInt(numStr2);
		
		
		
		num1 = num1 + num2;
		
		String numStr3 = new String(Integer.toString(num1));
		
		System.out.println(numStr3);
	}
	
	


}

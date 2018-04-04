package Core_Java;

public class questions_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1 I think this is what was asked. It does not ask for user input or methods
		double number1 = 10;
		double number2 = 12;
		
		double multiply = number1*number2;
		double subtract = number1 -number2 ;
		double add = number1 +number2;
		double divide = number1/number2;
		
	//	System.out.println(divide);
				
		
		//2 
		
		int numb1 = 3220;
		int numb2 = 320;
		int numb3 = 30;
		
		if (numb1 > numb2 && numb1 > numb3) {
			System.out.println(numb1);
		}
		if (numb2 > numb1 && numb2 > numb3) {
			System.out.println(numb2);
		}else {
			System.out.println(numb3);
		}
		
		//3 
		
		boolean a = true;
		boolean b = false;
		
		System.out.println(!a);
		System.out.println(a|b);
		System.out.println((!a&b)| (a&!b));
				
		
				
		
		
		
		
		
		
		
		
	}

}

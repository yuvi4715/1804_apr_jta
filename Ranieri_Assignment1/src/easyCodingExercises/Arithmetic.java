package easyCodingExercises;
import Syntax.functions;

public class Arithmetic {

	public static void main(String[] args) {
		
		double number1 = Double.parseDouble(args[0]);
		double number2 = Double.parseDouble(args[1]);
		String operator = args[2];
		
		System.out.println(calculator(number1,number2,operator));
						
	}
	
	public static double calculator(double number1,double number2, String operator) {
		functions f = new functions();
		
		if(operator.contains("+")) {
			return f.add(number1,number2);
		}
		
		if(operator.contains("-")) {
			return f.subtract(number1,number2);
		}
		
		// does not work
		if(operator.contains("*")) {
			return f.multiply(number1,number2);
		}
		
		if(operator.contains("/")) {
			return f.divide(number1,number2);
		}
				
		return 000000;
	}

	
}

package question36;

public class Arithmetic {
	static void doMath(int num1, int num2, String operator){
		if(operator.equals("+")) {
			System.out.println(num1+num2);
		}
		else if(operator.equals("*")){
			System.out.println(num1*num2);
		}
		else if(operator.equals("/")){
			if(num2==0) {
				System.out.print("Cannot divide by zero");
			}
			else {
				System.out.println(num1/num2);
			}
		}
		else if(operator.equals("-")){
			System.out.println(num1-num2);
		}
		else {
			System.out.println("Not a valid Operator");
		}
	}
}

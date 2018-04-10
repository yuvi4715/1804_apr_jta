package question36;

public class q36 {

	public static void main(String[] args) {
		int num1=0;
		int num2=0;
		String operator="";
		try {
			num1 = Integer.parseInt(args[0]);
		}
		catch(Exception e) {
			System.out.println("First entry not an integer. Please try again.");
			return;
		}
		try {
			num2 = Integer.parseInt(args[1]);
		}
		catch(Exception e) {
			System.out.println("Second entry not an integer. Please try again.");
			return;
		}
		try {
			operator = args[2];
		}
		catch(Exception e) {
			System.out.println("No operator entered. Please try again.");
			return;
		}
		
		Arithmetic.doMath(num1, num2, operator);
	}

}

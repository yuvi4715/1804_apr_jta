package easy_coding_exercises;

public class Arithmetic {
	
	public static void main(String[] args) {
		try {
			System.out.println(args[0]+" "+args[1]+" "+args[2]);
			//Arithmetic(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
		} catch (Exception e) {
			System.out.println("Invalid parameters!");
		}
				
	}
	
	public static void Arithmetic(int first, int second, String operator) throws Exception {
		switch (operator) {
		case "+":
			System.out.println(first + " + " + second + " = " + (first+second));
			break;
		case "-":
			System.out.println(first + " - " + second + " = " + (first-second));
			break;
		case "*":
			System.out.println(first + " * " + second + " = " + (first*second));
			break;
		case "/":
			System.out.println(first + " / " + second + " = " + (first/second));
			break;
		default:
			throw new Exception();
		}
		
	}

}

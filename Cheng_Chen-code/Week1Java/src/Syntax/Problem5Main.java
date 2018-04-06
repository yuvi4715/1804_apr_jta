package Problem5;

public class Problem5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc mycalcs = new Calc();
		
int a = 4, b = 8;
		
		System.out.println("4 + 8 = " + mycalcs.add(a, b));
		System.out.println("4 - 8 = " + mycalcs.subtract(a, b));
		System.out.println("4 * 8 = " + mycalcs.multiply(a, b));
		System.out.println("8 / 4 = " + mycalcs.divide(b, a));
	}

}

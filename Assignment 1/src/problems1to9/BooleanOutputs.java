package problems1to9;
//problem 3
public class BooleanOutputs {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		
		boolean a1 = !a;
		boolean a2 = a|b;
		boolean a3 = (!a&b) | (a & !b);
		
		System.out.println(a1 + "," + a2 + "," + a3 );
	}
}

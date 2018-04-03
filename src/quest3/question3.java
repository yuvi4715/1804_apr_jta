package quest3;

public class question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a,b;
		a = true;
		b = false;
		
		boolean x = !a;		
		System.out.println("Output of !a is " + x);

		boolean y = a|b;
		System.out.println("Output of a|b is " + y);
		
		boolean z = ((!a&b)|(a&!b));
		System.out.println("Output of (!a&b)|(a&!b) is " + z);
	}

}

// Write a program –declare two variables a & b and initialize them to true and false respectively. Get the output of the following computations:

package CoreJava;

public class question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = true;
		boolean b = false;
		System.out.println(!a);
		System.out.println(a | b);    
		System.out.println((!a & b) | (a & !b));
	}

}

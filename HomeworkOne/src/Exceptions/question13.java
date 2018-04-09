//Duck the exception at least once
package Exceptions;

public class question13 {

	public void ducking() throws ArrayIndexOutOfBoundsException, 
	ArithmeticException, NullPointerException {
		int[] i = { 1, 2, 3, 4, 5, 6 };
		System.out.println(i[30]);
	}
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		new question13().ducking();
	}

}

//Create a main method in a new class that:
//	Creates 2 customers
//	Uses each of the Customer class members

package ClassMembers;

import java.util.Scanner;

class question8 {

	public class Customer1	{
		public void print() {
			System.out.println("This is the first customer");
		}	
	}
	
	public class Customer2	{
		public void print() {
			System.out.println("This is the second customer");
		}	
	}
	
	public static void main(String[] args) {
		question8 demo = new question8();
		question8.Customer1 demo2 = demo.new Customer1();
		System.out.println(demo2);
	}


}

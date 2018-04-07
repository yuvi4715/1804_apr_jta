package assignment.Joey;
import java.util.Scanner;

import assignment.Joey.Syntax2Methods;

/**
 * 
 * create two classes. One class should contain only methods 
 * (add, subtract, multiply and divide). The other class should 
 * contain only the main() method which calls each of the methods 
 * from the previous class.
 * @author joeyi
 *
 */
public class Syntax2 {
	public static void main(String[] args) {
		System.out.println("Please enter 2 integers separated by space");
		Scanner console = new Scanner(System.in);
		try{
			int x=console.nextInt();
			int y=console.nextInt();
			Syntax2Methods.addNum(x,y);
			Syntax2Methods.subtractNum(x,y);
			Syntax2Methods.multiplyNum(x,y);
			Syntax2Methods.divideNum(x,y);
		} finally {
			console.close();
		}
	}
}

/**
 * Methods for Syntax2.java: create two classes. One class should contain only methods 
 * (add, subtract, multiply and divide). The other class should 
 * contain only the main() method which calls each of the methods 
 * from the previous class.
 * @author joeyi
 *
 */
class Syntax2Methods {
	
	   public static boolean isZero(int x, int y){
	         if (x==0 || y==0){
	                System.out.println("Numbers have to be non-zero.");
	                return true;
	         }
	         else return false;
	   }
	   public static void addNum(int x, int y){
	         int result;
	         if(!isZero(x, y)){
	               result=x+y;
	               System.out.println("Result of addition="+result);
	         }
	   }
	   public static void subtractNum(int x,int y){
	         if(!isZero(x,y)){
	               System.out.println("Result of subtraction="+Math.abs(x-y));
	         }
	   }
	   public static void multiplyNum(int x, int y){
	         if(!isZero(x,y)){
	               System.out.println("Result of multiplication="+(x*y));
	         }
	   }
	   public static void divideNum(int x, int y){
	         if(!isZero(x,y)){
	               System.out.println("Result of division="+(float)(x/y));
	         }
	   }
	}



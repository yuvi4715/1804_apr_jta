package assignment.Joey;

import java.util.Scanner;

/**
a program to add, subtract, multiply and 
divide two numbers using methods with 
parameters using only one class.
 * @author Joey Ni
 *
 */
public class Syntax1{
	public static void main(String[] args) {
		//test	
		System.out.println("Please enter 2 integers separated by space");
		Scanner console = new Scanner(System.in);
		try{
			int x=console.nextInt();
			int y=console.nextInt();
			addNum(x,y);
			subtractNum(x,y);
			divideNum(x,y);
			multiplyNum(x,y);
		} finally {
			console.close();
		}
		
		
	}
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

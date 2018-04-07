package com.revature.exception;

public class ExceptionExample {
	
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		//new ExceptionExample().divideByNumbers(20, 0);
	    //new ExceptionExample().riskyBehavior();
		new ExceptionExample().riskyBehavior2();
	}
	
	
	public void riskyBehavior2() throws ArrayIndexOutOfBoundsException {
		int [] i= {1,2,3,4,5};
		System.out.println(i[30]);
	}
	
	public void riskyBehavior() {
		String s="asfdfgf";
		try {
		int i=Integer.parseInt(s); //parse string into int and convert to Integer
		}catch(NumberFormatException e) {
			System.out.println("number format");
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	public  void pointerException() {
		String s1=null;
		try {
		System.out.println(s1);
		} catch (ArithmeticException | ClassCastException a) {
			a.getMessage();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				s1 ="example";
				System.out.println(s1);
			}catch(NullPointerException n) {
				n.getClass();
			}finally {
				System.out.println("second finally");
				try {
					System.out.println("third try");
				}finally {
					System.out.println("third finally");
				}
			}
		}
	}
	public int divideByNumbers(int x, int y) {
		int z=0;
		String s1=null;
		
		try {
			z=x/y;
			
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}catch (Exception e) {
			//e.getMessage();
			e.printStackTrace();
		}
		return z;
	}
		
	
}

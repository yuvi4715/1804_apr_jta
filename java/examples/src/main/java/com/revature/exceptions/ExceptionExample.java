package com.revature.exceptions;

public class ExceptionExample {

	public int divideByNumbers(int x, int y) {
		int z = 0;
		try {
			z = x / y;
		} catch (ArithmeticException ae) {
			ae.getMessage();
		} catch (Exception e) {
			// e.getMessage();
			e.printStackTrace();
		}
		return z;
	}

	public String pointerException() {
		String s1 = null;
		try {
			System.out.println(s1);
		} catch (ArithmeticException | ClassCastException | ArrayIndexOutOfBoundsException cc) {
			cc.getMessage();
		} catch (NullPointerException np) {
			np.getMessage();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				s1 = "try to jump again from a building";
				System.out.println(s1);
				return s1;
			} catch (NullPointerException np) {
				np.getClass();
			} finally {
				System.out.println("internal finally block");
				try {
					System.out.println("another risky behavior");
				} finally {
					System.out.println("is this confusing enough??");
				}
			}
		}
		System.out.println(s1);
		return s1;
	}

	public void riskyBehavior() {
		String s = "dlaksdflaskdjflkasd";
		try {
			int i = Integer.parseInt(s);
		} catch (NullPointerException np) {
			System.out.println("null pointer");
		} catch (NumberFormatException nf) {
			System.out.println("number format");
		}
	}

	public void riskyBehavior2() throws ArrayIndexOutOfBoundsException, 
	ArithmeticException, NullPointerException {
		int[] i = { 1, 2, 3, 4, 5, 6 };
		System.out.println(i[30]);
	}

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		// new ExceptionExample().divideByNumbers(20, 0);
		// new ExceptionExample().riskyBehavior();
		new ExceptionExample().riskyBehavior2();
	}

}

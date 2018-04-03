package com.revature.assignments.weekone;
//Ed Marable

//Revature Week One Assignment

public class WeekoneAssignment {

	static class CoreJava {
		int hardCodedNumber1 = 2;
		int hardCodedNumber2 = 5;
		int hardCodedNumber3 = 9;

		boolean a = true;
		boolean b = false;

		void display() {
			System.out.println(
					"Q1: " + hardCodedNumber1 + "+" + hardCodedNumber2 + "=" + (hardCodedNumber1 + hardCodedNumber2));
			if ((hardCodedNumber1 > hardCodedNumber2) && (hardCodedNumber1 > hardCodedNumber3))
				System.out.println("Q2: " + hardCodedNumber1 + ">" + hardCodedNumber2 + "&" + hardCodedNumber3);
			else if ((hardCodedNumber2 > hardCodedNumber1) && (hardCodedNumber2 > hardCodedNumber3))
				System.out.println("Q2: " + hardCodedNumber2 + ">" + hardCodedNumber1 + "&" + hardCodedNumber3);
			else if ((hardCodedNumber3 > hardCodedNumber1) && (hardCodedNumber3 > hardCodedNumber2))
				System.out.println("Q2: " + hardCodedNumber3 + ">" + hardCodedNumber1 + "&" + hardCodedNumber2);
			System.out.println("Q3: " + "!a = " + (!a) + ", a | b  = " + (a | b) + ", (!a & b) | (a & !b) = "
					+ ((!a & b) | (a & !b)));

		}

	}

	static class Syntax {

		int add(int numOne, int numTwo) {
			return (numOne + numTwo);
		}

		int subtract(int numOne, int numTwo) {
			return (numOne - numTwo);
		}

		int multiply(int numOne, int numTwo) {
			return (numOne - numTwo);
		}

		int divide(int numOne, int numTwo) {
			return (numOne - numTwo);
		}

		String ifStatement(boolean flag0, boolean flag1) {
			if (flag1 || !flag1)
				return ("if");

			return ("base return");
		}

		String ifThenElseStatement(boolean flag0, boolean flag1) {
			if (flag1)
				return ("if");

			if (flag0)
				return ("else");

			return ("else");
		}

		String ifThenElseIfStatement(boolean flag0, boolean flag1) {
			if (false)
				return ("if");
			else if (flag0 || !flag0)
				return ("else if");
			return ("base return");
		}

		String switchStatement(int temp) {
			switch (temp) {
			case 1:
				return ("switch");
			case 2:
				return ("switch");
			default:
				return ("switch default");
			}

		}

		String whileStatement(boolean temp) {
			while (temp)
				return ("while");
			return ("base return");
		}

		String doWhileStatement(boolean temp) {

			do {
				return ("do-while");
			} while (temp);
		}
		// return ("base return");

		String forStatement(int temp) {
			for (int i = 1; i < temp; i++) {
				return ("for");
			}

			return ("base return");
		}

		String forEachStatement(int[] temp) {
			for (int temp0 : temp) {
				return ("for each");
			}
			return ("base return");
		}

		String breakStatement(int temp) {
			for (int i = 1; i < temp; i++) {
				break;

			}
			return ("break");

		}

		String continueStatement(int temp) {
			temp: for (int i = 1; i < 5; i++) {
				continue temp;
			}

			return ("continue");
		}

		String returnStatement() {
			return ("return");
		}

		void display() {
			int testTemp00 = 5;
			int testTemp01 = 2;
			int[] tesTempArray00 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			System.out.println("Q4: numbers: " + testTemp00 + " & " + testTemp01 + " ,Add = "
					+ add(testTemp00, testTemp01) + " ,subtract = " + subtract(testTemp00, testTemp01) + " ,divide = "
					+ divide(testTemp00, testTemp01) + " ,Multiply = " + multiply(testTemp00, testTemp01));
			System.out.println("Q6: " + ifStatement(true, false) + ", " + ifThenElseStatement(true, false) + ", "
					+ ifThenElseIfStatement(true, false) + ", " + switchStatement(testTemp01) + ", "
					+ whileStatement(true) + ", " + doWhileStatement(true) + ", " + forStatement(testTemp00) + ", "
					+ forEachStatement(tesTempArray00) + ", " + breakStatement(testTemp01) + ","
					+ continueStatement(testTemp00) + ", " + returnStatement());

		}

	}

	public static void main(String[] args) {
		WeekoneAssignment.CoreJava CoreJavaSegment = new WeekoneAssignment.CoreJava();
		CoreJavaSegment.display();
		WeekoneAssignment.Syntax SyntaxSegment = new WeekoneAssignment.Syntax();
		SyntaxSegment.display();
		/// Q5 Start
		int testTemp00 = 14;
		int testTemp01 = 2;
		System.out.println("**Q5: numbers: " + testTemp00 + " & " + testTemp01 + " ,Add = "
				+ SyntaxSegment.add(testTemp00, testTemp01) + " ,subtract = "
				+ SyntaxSegment.subtract(testTemp00, testTemp01) + " ,divide = "
				+ SyntaxSegment.divide(testTemp00, testTemp01) + " ,Multiply = "
				+ SyntaxSegment.multiply(testTemp00, testTemp01));
		/// Q5 End
	}

}

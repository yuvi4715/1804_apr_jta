/**
 * 
 */
package com.revature.assignments.weekone.javasyntax;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 3:13:14 PM
 */
//Q6
public class ControlStatements {
	String ifStatement(boolean flag0, boolean flag1) {
		if (flag1)
			return ("if");

		return ("base return");
	}

	String ifThenElseStatement(boolean flag0, boolean flag1) {
		if (flag1)
			return ("if");
		else
			return ("else");
	}

	String ifThenElseIFStatement(boolean flag0, boolean flag1) {
		if (flag1)
			return ("if");
		else if (flag0)
			return ("else if");
		return ("base return");
	}

	String switchStatement(int temp) {
		switch(temp) {
		case 1:
			return ("case 1");
		case 2: 
			return ("case 2");
		default:
			return("default");
	}
	
	}
	String whileStatment(boolean temp) {
		while (temp)
			return("while");
		return ("base return");
	}
	String doWhileStatment(boolean temp) {
		
		do {
			System.out.println("do");
		}
		while (temp); {
			return("while");
		}
		//return ("base return");
	
	}
}

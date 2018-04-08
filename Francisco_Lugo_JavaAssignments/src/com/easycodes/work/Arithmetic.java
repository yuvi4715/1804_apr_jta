package com.easycodes.work;

public class Arithmetic {
	
public static void main(String[] args) {
		
		boolean flag;
		int x =0 ,y=0 , count = 0;
		String op = "";
/*		args = new String[3];
		args[0] = "15";
		args[1] = "5";
		args[2] = "/";*/
		
		
		for(String s: args) {
			flag = checkIfNum(s);
			if((flag == true) &&(count == 0)) {
				x = Integer.parseInt(s);
			}
			else if((flag == true) &&(count == 1)) {
				y = Integer.parseInt(s);
			}
			else
			{
				op = s;
			}
			count++;
		}
		
		if(op.equals("+")) {
			System.out.println(x + op + y + " = " + (x+y));
		}
		else if(op.equals("-")) {
			System.out.println(x + op + y + " = " + (x-y));
		}
		else if(op.equals("*")) {
			System.out.println(x + op + y + " = " + (x*y));
		}
		else if(op.equals("/")) {
			System.out.println(x + op + y + " = " + (x/y));
		}
		else {
			System.out.println("The selected operator is not one of the mentioned above. Exiting program...");
		}
	}

	private static boolean checkIfNum(String s) {
		
		try {
			Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

}


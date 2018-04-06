package question3;

import java.util.StringTokenizer;

public class q3 {

	public static void main(String[] args) {
		boolean a=true;
		boolean b=false;

		boolean a1=!a;
		boolean a2=a|b;
		boolean a3=(!a&b)|(a&!b);
		System.out.println(a+" : "+a2+" : "+a3);
	}

}
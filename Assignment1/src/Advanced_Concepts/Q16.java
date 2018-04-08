//John Eifert
package Advanced_Concepts;

import java.lang.StringBuilder;

public class Q16
{
	public static void main(String args[])
	{
		StringBuilder obj = new StringBuilder();
		
		obj.append("xy");
		obj.insert(2, 'z');
		obj.reverse();
		
		System.out.println(obj);
	}
}

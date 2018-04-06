package Exceptions;
public class Problem18 {
	public static void main(String[] args) 
	{
		String a = "20", b = "30";
		System.out.println(StringAdd(a,b));
	}
	
	public static int StringAdd (String x, String y)
	{
		return Integer.parseInt(x) + Integer.parseInt(y);
	}
}

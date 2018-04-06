package Exceptions;

public class Problem19 {
	public static void main(String[] args) 
	{
		String a = "20", b = "30";
		StringAdd(a,b);
	}
	
	public static void StringAdd (String x, String y)
	{
		System.out.println(Integer.parseInt(x) + Integer.parseInt(y));
		System.gc();
	}
}

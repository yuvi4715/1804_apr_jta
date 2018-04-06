import java.util.StringTokenizer;

public class Problem17 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		StringTokenizer delimit = new StringTokenizer("pickles:ketchup:mustard:onion",":");
		
		while(delimit.hasMoreTokens())
		{
			System.out.println(delimit.nextToken());
		}
	}

}

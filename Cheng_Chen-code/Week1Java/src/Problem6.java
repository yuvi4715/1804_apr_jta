
public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1;
		
		System.out.println("a = 1.");
		
		if(a < 3)
			System.out.println("a is less than 3.");
		
		if (a > 3)
			System.out.println("This statement should not be printed.");
		else
			System.out.println("a is still less than 3.");
		
		if (a < 1)
			System.out.println("a is less than 1.");
		else if (a == 1)
			System.out.println("a is equal to 1.");
		else
			System.out.println("a is greater than 1.");
		
		switch(a)
		{
			case 0:
				System.out.println("a = 0.");
				break;
			
			case 1:
				System.out.println("a = 1.");
				break;
			
			case 2:
				System.out.println("a = 2.");
				break;
			
			default:
				System.out.println("a is not equal to 1, 2, or 3.");
				break;
		}
		
		for(int i = 0; i < 5; i++)
			System.out.println("This statement will repeat 5 times.");
		
		a = 0;
		while(a < 5)
		{
			System.out.println(a);
			a++;
		}
		
		a = 0;
		do
		{
			System.out.println("This statement will not repeat.");
			a++;
		}
		while(a < 0);
		
		int[] test_array = {1, 2, 3, 4, 5};
		for(int ta:test_array)
			System.out.println("Index: " + ta);
		
		a = 0;
		while(a < 100)
		{
			if (a<100)
				System.out.println("This loop is infinite.");
			System.out.println("This loop will now break.");
			break;
		}
		
		System.out.println("The next loop will skip 1.");
		for(a = 0; a<5;a++)
		{
			if(a==1)
				continue;
			else
				System.out.println(a);
		}
		
		System.out.println("Return test, calling return(will return 1): " + returnTest());
	}
	
	 public static int returnTest()
	 {
		return 1;
	 }
}

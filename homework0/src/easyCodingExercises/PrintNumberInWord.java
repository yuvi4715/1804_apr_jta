package easyCodingExercises;

public class PrintNumberInWord 
{
	public PrintNumberInWord(int key)
	{
		System.out.println("If Implmentation ");
		if(key == 1)
		{
			System.out.println("ONE");
		}
		else if(key == 2)
		{
			System.out.println("TWO");
		}
		else if(key == 3)
		{
			System.out.println("THREE");
		}
		else if(key == 4)
		{
			System.out.println("FOUR");
		}
		else if(key == 5)
		{
			System.out.println("FIVE");
		}
		else if(key == 6)
		{
			System.out.println("SIX");
		}
		else if(key == 7)
		{
			System.out.println("SEVEN");
		}
		else if(key == 8)
		{
			System.out.println("EIGHT");
		}
		else if(key == 9)
		{
			System.out.println("NINE");
		}
		else if(key == 10)
		{
			System.out.println("TEN");
		}
		else
		{
			System.out.println("OTHER");
		}
		
		
		System.out.println("Switch Implementation ");
		String response = "";
		switch (key)
		{
			case 1:  response = "ONE";
					break;
			case 2:  response = "TWO";
					break;
			case 3:  response = "THREE";
					break;
			case 4:  response = "FOUR";
                 	break;
			case 5:  response = "FIVE";
                 	break;
			case 6:  response = "SIX";
                 	break;
			case 7:  response = "SEVEN";
					break;
			case 8:  response = "EIGHT";
                 	break;
			case 9:  response = "NINE";
                 	break;
			case 10: response = "TEN";
                 	break;
			default: response = "OTHER";
					break;
		}
		System.out.println(response);	
		
	}
}

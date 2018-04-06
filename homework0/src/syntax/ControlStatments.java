package syntax;

public class ControlStatments 
{
	public static void main(String[] args) 
	{
		ControlStatments cS = new ControlStatments();
		cS.theIfThenStatement(true);
		cS.theIfThenStatement(false);
		cS.theSwitchStatement(8);
		cS.theSwitchStatement(23);
		cS.theSwitchStatement(2);
		cS.theLoops(9, true);
	}
	
	public void theIfThenStatement(boolean condition)
	{
		if(condition == true)
		{
			System.out.println("If the Condition is True then this'IF Statement' should appear. ");
		}
		else if(condition == false)
		{
			System.out.println("If the Condition is False then this 'IF ELSE Statement' should appear. ");
		}
		else 
		{
			System.out.println("If the Condition is null then this 'ELSE Statement' should appear. ");
		}
	}
	
	public void theSwitchStatement(int condition)
	{
		System.out.println("These are Switch statements: ");
		String response = "";
		switch (condition)
		{
			case 1:  response = "case 1";
					break;
			case 2:  response = "case 2";
					break;
			case 3:  response = "case 3";
					break;
			case 4:  response = "case 4";
                 	break;
			case 5:  response = "case 5";
                 	break;
			case 6:  response = "case 6";
                 	break;
			case 7:  response = "case 7";
					break;
			case 8:  response = "case 8";
                 	break;
			case 9:  response = "case 9";
                 	break;
			case 10: response = "case 10";
                 	break;
			default: response = "default case";
					break;
		}
		System.out.println(response);	
	}
	
	public void theLoops(int iterations, boolean condition)
	{
		int answer = 0;
		for(int i = iterations; i <= 20 ;i++)
		{
			answer= answer +1;
		}
		System.out.println("This For Loop Iterated " + answer + " times! ");
		answer = 0;
		while(condition)
		{
			answer++;
			if( answer == 13) break;
		}
		System.out.println("This While Loop Broke at the " + answer + " Loop! ");
		answer = 0;
		while(condition)
		{
			answer++;
			if( answer == 13) continue;
			if(answer == 40)
			{
				condition = false;
			}
		}
		System.out.println("This While Loop Broke at the " + answer + " Loop and Continued until! 40");
		do
		{
			System.out.println("This Do-While Loop ran 1 time even though the condition was set false!");
			condition = false;
		}while(condition);
		
	}
	
	
	
}

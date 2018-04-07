package coreJava;

/**
* Dominick Sermeno
* Batch 1804
* Q's: 2
* 
*/
public class GreatestOfThree 
{
	public void greatest(int first, int second, int third)
	{
		String answer = "";
		if ((first > second) && (first > third))
		{
			answer = "First is greatest!";
		}
		else if((second > first) && (second > third))
		{
			answer = "Second is greatest!";
		}
		else if((third > first) && (third > second))
		{
			answer = "Third is greatest!";
		}
		else 
		{
			answer = "NONE are the greatest!";
		}
		System.out.println("Which value is the Greatest?: " + answer);
	}

}

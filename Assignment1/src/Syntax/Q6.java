//John Eifert
package Syntax;

public class Q6 
{
	public static void main(String args[])
	{
		int num=1;
		System.out.println("num = " + num);
		
		//Increment num until num>=4:
		while(num < 4)
		{
			num++;
			System.out.println("num = " + num);
		}
		
		//Decrement num each time the for loop iterates:
		for(int i=0; i<2; i++)
		{
			//When i==1, skip to i==2:
			if(i == 1)
			{
				continue;
			}
			num--;
			System.out.println("num = " + num);
		}
		
		//Increment num until num>=5:
		do
		{
			num++;
			System.out.println("num = " + num);
		}
		while(num < 5);
		
		//If num<3, add 5 to num; otherwise, add 2 to num:
		if(num < 3)
		{
			num+=5;
			System.out.println("num = " + num);
		}
		else
		{
			num+=2;
			System.out.println("num = " + num);
		}
		
		//Increment num until num>=9:
		while(true)
		{
			num++;
			System.out.println("num = " + num);
			if(num > 9)
			{
				break;
			}
		}
		
		//Decrement num if num==9 or num==11, increment num if num==10:
		switch(num) {
			case 9:
				num--;
				break;
			case 10:
				num++;
				break;
			case 11:
				num--;
				break;
		}
		System.out.println("num = " + num);
	}
}

package easyCoding32;

//Write a program called CheckPassFail which prints "PASS" if the int 
//variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.

public class easyCoding32 
{
	public static void main(String[] args) 
	{
		int mark = 49;
		CheckPassFail(mark);
		mark = 13;
		CheckPassFail(mark);
		mark = 50;
		CheckPassFail(mark);
	}
	
	public static void CheckPassFail(int mark) {
		if (mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
	}
}


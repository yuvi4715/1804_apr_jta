package Bonus;

public class Problem52 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int num = 123456;
		int reversed = 0;
		
		while(num != 0)    
		{      
			reversed = reversed * 10;     
			reversed = reversed + num%10;  
			num = num/10; 
		}
 
		System.out.println("Reverse of input number is: "+reversed);
	}

}

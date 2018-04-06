package Bonus;

public class Problem53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 3, 5, 5, 6, 8, 9};
		 
		for (int i = 0; i < test.length-1; i++)	        
		{	            
			for (int j = i+1; j < test.length; j++)          
			{    
				if ((test[i] == test[j]) && (i != j))                
				{                  
					System.out.println("Duplicate Element : "+test[j]);           
				}      
			}  
		}
	}
}

package assignment.Joey.AdvancedCodingPrograms;
/**
6. Write a Java program to check if a number is Armstrong or not.
Armstrong number: sum of a number's digits raised to (the number of its digits) 
is equal to the number itself
Ex. 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371. 
*
*/
public class Armstrong {
	public static void main(String[] args) {
		//System.out.println(Integer.toString(345).length());
		System.out.println(checkArmstrong(371));
		System.out.println(checkArmstrong(1));
		System.out.println(checkArmstrong(37));
		System.out.println(checkArmstrong(370));
		System.out.println(checkArmstrong(30));
		System.out.println(checkArmstrong(407));
		System.out.println(checkArmstrong(153));
		System.out.println(checkArmstrong(90));
		System.out.println(checkArmstrong(0));
		
		
	}
	public static boolean checkArmstrong(int x) {
		String temp=Integer.toString(x);
		double [] tempSet=new double[temp.length()];
		int sum=0;
		for(int i=0; i<temp.length(); i++)
		{	
			char t2=temp.charAt(i);
			tempSet[i]=Math.pow(Character.getNumericValue(t2), temp.length());
			//System.out.println(tempSet[i]);
			sum+=tempSet[i];
		}
		if (sum==x) return true;
		return false;
		

		
	}

}

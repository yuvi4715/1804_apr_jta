// Create two String objects with number values (i.e. “20). Write a method that adds the two.


package AdvancedConcepts;

public class question18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(concat("10","20"));
	}
	
	public static int concat(String num1, String num2) {
		return (Integer.parseInt(num1) + Integer.parseInt(num2));
		
	}

}

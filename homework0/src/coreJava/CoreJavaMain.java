package coreJava;

public class CoreJavaMain 
{

	public static void main(String[] args) 
	{
		////Tester for Q's 1 and 5/////
		SimpleCalculator cal = new SimpleCalculator();
		cal.add(5, 8);
		cal.subtract(9, 5);
		cal.multiply(12, 15);
		cal.divide(144, 12);
		////////////////////////////////
		
		////Tester for Q's 2////////////
		GreatestOfThree g1 = new GreatestOfThree();
		GreatestOfThree g2 = new GreatestOfThree();
		GreatestOfThree g3 = new GreatestOfThree();
		g1.greatest(13, 17, 17);
		g2.greatest(13, 17, 14);
		g3.greatest(42, 17, 13);
		////////////////////////////////
		
		SimpleLogic l = new SimpleLogic();
		l.logic();
		
		

	}

}

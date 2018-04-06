package Syntax;
import java.util.Scanner;

// Problem 6
public class ControlStatements {
	
	Scanner t = new Scanner(System.in);
	
	public ControlStatements() {
		System.out.println("Enter 'y' or something after each example completes to continue.");
		demoIf();
		t.next();
		
		demoSwitch();
		t.next();
		
		demoWhile();
		t.next();
		
		demoContinue();
		t.next();
		
		demoWhile();
		t.next();
		
		demoDoWhile();
		t.next();
		
		demoBreak();
		t.next();
		
		demoContinue();
		
		t.close(); // Close keyboard
	}
	
	public void demoIf() {
		boolean flowerIsRed = true;
		if (flowerIsRed == true) {
			System.out.println("The flower is red");
		}
	}
	
	public void demoSwitch() {
		String choice; 
		System.out.println("Enter a color from the Flag! There is Red, White, and Blue");
		choice = t.next();
		
		String selection = choice.toLowerCase();
		
		switch(selection) {
			case "red" : 
				System.out.println("You chose red!" );
				break;
			case "white" : 
				System.out.println("You chose white!");
				break;
			case "blue" : 
				System.out.println("You chose blue!!");
				break;
			
			default : 
				System.out.println("Woah there, you didnt pick them!");		
			
		}
	}
	
	public void demoFor() {
		System.out.println("Hey, I am going to count to 10 really fast!");
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("All done!");
	}
	
	public void demoWhile() {
		System.out.println("Going to count from 10 to zero!");
		int i = 10;
		while (i > 0) {
			System.out.println(i);
			i--;
		}
		System.out.println("Done!");
		
	}

	public void demoDoWhile() {
		System.out.println("Going to count by 2 up to 20!");
		int i = 0;
		do {
			System.out.println(i);
			i = i+2;
		} while (i <= 20);
	}
	
	public void demoBreak() {
		System.out.println("I am going to count up to 20, but if I hit 10 Ill stop!");
		for (int i = 0; i <= 20; i++) {
			System.out.println(i);
			if (i==10) {
				System.out.print("Woah hit 10!");
				break;
			}
				
		}
	}
	
	public void demoContinue() {
		System.out.println("I'll count up to 20, I'll reach 19 and then go back to 15, then 20!");
		boolean recount = false;
		for (int i = 0; i <= 20; i++) {
			System.out.println(i);
			if (i == 19 && recount != true) {
				i = i - 4;
				System.out.println("Going back to 15");
				recount = true;
				continue;
			}				
		}
	}
	
	
	public static void main(String[] args) {
		ControlStatements t = new ControlStatements();
		
	}

}

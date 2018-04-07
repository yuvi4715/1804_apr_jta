package assignment.Joey.EasyCodingProgram;
/**
3. Write a program called PrintNumberInWord which prints 
"ONE", "TWO",... , "NINE", "OTHER" 
if the int variable "number" is 1, 2,... , 9, or other,
 respectively. Use (a) a "nested-if" statement; (b) a "switch-case" statement.

*/
public class PrintNumberInWord {
	public static void main(String[] args) {
		int number =2;
		switch(number){
		case 1: System.out.println("One"); break;
		case 2: System.out.println("Two"); break;
		case 3: System.out.println("Three"); break;
		case 4: System.out.println("Four"); break;
		case 5: System.out.println("Five"); break;
		case 6: System.out.println("Six"); break;
		case 7: System.out.println("Seven"); break;
		case 8: System.out.println("Eight"); break;
		case 9: System.out.println("Nine"); break;
		default: System.out.println("Other");
		}
		
		if (number<=9) {
			for(int i=1; i<=9; i++) { 
				if (i==1)  System.out.println("One"); 
				if (i==2)  System.out.println("Two"); 
				if (i==3)  System.out.println("Three"); 
				if (i==4)  System.out.println("Four"); 
				if (i==5)  System.out.println("Five"); 
				if (i==6)  System.out.println("Six"); 
				if (i==7)  System.out.println("Seven"); 
				if (i==8)  System.out.println("Eight"); 
				if (i==9)  System.out.println("Nine"); 
		} 
	} else System.out.println("OTHER");
	}
}

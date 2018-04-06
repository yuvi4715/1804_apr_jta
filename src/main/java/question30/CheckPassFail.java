package question30;

public class CheckPassFail {
	static int checkNumber=50;
	
	static String checkNum(int mark) {
		if(mark>checkNumber) {
			return "Pass";
		}
		else {return "Fail";}
	}
}
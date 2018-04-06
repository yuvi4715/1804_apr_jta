package question5;

public class Opp {

	static int add(int num1, int num2){
		return num1+num2;
	}
	static int multi(int num1, int num2){
		return num1*num2;
	}
	static float div(int num1, int num2){
		if(num2!=0){
			return num1+num2;	
		}
		else{
			return 0;
		}
	}
	static int sub(int num1, int num2){
		return num1-num2;
	}
}
package question4;

public class q4 {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 5;
		System.out.println(add(num1,num2));
		System.out.println(multi(num1,num2));
		System.out.println(sub(num1,num2));
		float div=div(num1,num2);
		if(div==0){
			System.out.println(div);
		}
		else{
			System.out.println("Error, dividing by zero");
		}
	}

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
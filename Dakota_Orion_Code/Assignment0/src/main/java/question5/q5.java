package question5;

public class q5 {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 5;
		System.out.println(Opp.add(num1,num2));
		System.out.println(Opp.multi(num1,num2));
		System.out.println(Opp.sub(num1,num2));
		float div=Opp.div(num1,num2);
		if(div==0){
			System.out.println(div);
		}
		else{
			System.out.println("Error, dividing by zero");
		}
	}
}
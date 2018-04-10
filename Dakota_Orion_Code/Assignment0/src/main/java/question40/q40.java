package question40;

public class q40 {

	public static void main(String[] args) {
		iterHundredFib(1,1);
		recurHundredFib(1,1,100);
	}
	
	static void iterHundredFib(long num1, long num2) {
		long swap=0;
		for(int i=0;i<100;i++) {
			swap=num1+num2;
			System.out.println(num1);
			num1=num2;
			num2=swap;
		}
	}
	
	static void recurHundredFib(long num1, long num2, int i) {
		if(i<=0) {
			return;
		}
		System.out.println(num1);
		recurHundredFib(num2,num1+num2,i-1);
	}
}

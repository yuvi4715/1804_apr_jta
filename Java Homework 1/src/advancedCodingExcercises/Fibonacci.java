package advancedCodingExcercises;
// problem 40 - print out fibonacci numbers using nonrecursive and recurisve methods
import java.math.BigInteger;

public class Fibonacci {

	 BigInteger n1 = BigInteger.ZERO; // Big integer is used as the numbers will get very large
	 BigInteger n2 = BigInteger.ONE;
	 BigInteger n3;
	 int count = 100;
	 int i;
	 
	 public Fibonacci() {
		 printFibonacciNonRecursive();
		 System.out.println("Recursive here");
		 n1 = BigInteger.ZERO;
		 n2 = BigInteger.ONE;
		 printFibonacciRecursive(n1, n2, 1);
	 }

	 
	 void printFibonacciNonRecursive() {
		 
		 System.out.print(n1+" "+n2);//printing 0 and 1 
		 
		 for (i =2; i < count; i++) {
	
			 n3 = n1.add(n2);
			 System.out.println(" " + n3);
			 n1 = n2;
			 n2 = n3;
		 }
		 
		 System.out.println("Non-Recursive here");
		 
	 }

	
	 
	void printFibonacciRecursive(BigInteger n1, BigInteger n2, int count) {
		BigInteger currentNum = n1.add(n2);
		count++;
		
		n1 = n2;
		n2 = currentNum;
		
		if (count > 99) {
			return;
		}
		System.out.println(currentNum);
		printFibonacciRecursive(n1, n2, count);
	}
		 
	 
	 public static void main(String[] args) {
		Fibonacci t = new Fibonacci();
	}
	
}

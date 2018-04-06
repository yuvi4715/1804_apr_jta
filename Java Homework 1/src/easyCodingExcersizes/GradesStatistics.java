package easyCodingExcersizes;
// problem 37, write class the takes all grades determines min, max, average, and standard deviation
import java.util.Scanner;

public class GradesStatistics {
	int[] scores;
	int N;
	Scanner k = new Scanner(System.in);
	
	public GradesStatistics() {
		getGrades();
		getAverage();
		getMinimum();
		getMaximum();
		getStandardDeviation(scores);
		
	}
	
	boolean validate(String input) {
		boolean valid = false;
		if (input.contains("[a-zA-Z]+")) {
			System.out.println("Error, you should enter an integer");
			valid = false;
		} else {
			valid = true;
		}
		return valid;
	}
		
	void getGrades() {
		System.out.println("Enter number of grades to record");
		String n = k.next();
		if (n.matches(("[0-9]+"))) { // using matches to determine validity, if input fails ends program
			N = Integer.parseInt(n);
		}else {
			System.out.println("Invalid output, ending program");
			System.exit(0);
		}
		
		
		scores = new int[N];
		int i = 0;
		int j = 1;
		String input;
		while (i < N) {
			System.out.println("Enter grade " + j);
			input = k.next();
			if (input.matches(("[0-9]+"))) { // validating
				scores[i] = Integer.parseInt(input);
				i++;
				j++;
			} else {
				System.out.println("Error, invalid input. Exiting...");
				System.exit(0);
			}
		}
	}
	
	void getMinimum() {
		int minimum = 100;
		for (int i = 0; i<N; i++) {
			if (minimum > scores[i]) {
				minimum = scores[i];
			}
		}
		
		System.out.println("The Lowest score is: " + minimum);
		
	}
	
	void getMaximum() {
		int maximum = 0;
		for (int i = 0; i < N; i++) {
			if (maximum < scores[i]) {
				maximum = scores[i];
			}
		}
		
		System.out.println("The highest score is: " + maximum);
	}
		
	void getStandardDeviation(int scores[]) {
		double sum = 0.0;
		double standardDeviation = 0.0;
		
		for(double num: scores) {
			sum += sum;
		}
		
		double mean = sum/N;
		
		for (double num: scores) {
			standardDeviation += Math.pow(num - mean,2);
		}
		System.out.println("The standard deviation is " + standardDeviation/N);
	}
	
	void getAverage() {
		int total = 0;
		int i = 0;
		while (i < N) {
			total = total + scores[i];
			i++;
		}
		
		System.out.println("Average is " + (total/N));
	}
	
	public static void main(String[] args) {
		GradesStatistics t = new GradesStatistics();
	}
}

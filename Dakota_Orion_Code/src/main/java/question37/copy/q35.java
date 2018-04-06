package question37.copy;

import question35.GradesStatistics;

public class q35 {

	public static void main(String[] args) {
		int[] scores = new int[args.length];
		int i=0;
		for(String z : args) {
			try {scores[i] = Integer.parseInt(z);
				if(scores[i]>100||scores[i]<0) {
					System.out.println("invalid entry below 0 or over 100, try again");
					return;
				}
				i++;
			}
			catch(Exception e) {
				System.out.println("invalid not integer entry, try again.");
				return;
			}
		}
		GradesStatistics.gradesStats(scores);
	}

}

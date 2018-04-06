package question37;

public class GradesStatistics {

	public static void gradesStats(int[] args) {
		int max=0;
		int min=100;
		int sum=0;
		int count=0;
		int average=0;
		int sqrSum=0;
		double standardDiv=0;
		if(args.length==0) {
			System.out.println("No data entered, try again");
			return;
		}
		for(int x : args) {
			if(x>max) {
				max=x;
			}
			if(x<min) {
				min=x;
			}
			sum+=x;
			count++;
		}
		average=sum/count;
		for(int z : args) {
			sqrSum+=Math.pow(average-z,2);
		}
		standardDiv=Math.sqrt(sqrSum/count);
		System.out.println("Max: "+max);
		System.out.println("Min: "+min);
		System.out.println("Average: "+average);
		System.out.println("Standard Deviation: "+standardDiv);
	}

}

package question53;

public class q53 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
		Dup result= findDup(nums);
		if(result.isBol()==true) {
			System.out.println(result.getNum());
		}
		else {
			System.out.println("No Duplicate values");
		}
	}
	
	static Dup findDup(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int z=i+1;z<arr.length;z++) {
				if(arr[i]==arr[z]) {
					return new Dup(arr[i],true);
				}
			}
		}
		return new Dup(0,false);
	}
}

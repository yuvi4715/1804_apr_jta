package question43;

public class q43 {

	public static void main(String[] args) {
		isArmstrongNum(371);

	}
	
	static void isArmstrongNum(int num) {
		String[] nums = Integer.toString(num).split("");
		int val=0;
		for(int i=0;i<nums.length;i++) {
			val+=Math.pow(Integer.parseInt(nums[i]),nums.length);
		}
		if(val==num) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}

}

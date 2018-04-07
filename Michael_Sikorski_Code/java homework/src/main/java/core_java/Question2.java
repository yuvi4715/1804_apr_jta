package core_java;

public class Question2 {

	public Question2() {
		System.out.println("-- Question 2 --");
		int[] nums = { 22, 5, 33, 6, 44, 7 };
		int index = 0;
		int max = -1;
		while (index < nums.length) {
			if (nums[index] > max) {
				max = nums[index];
			}
			index++;
		}
		System.out.println("Largest number: " + max);
		System.out.println();
	}

}

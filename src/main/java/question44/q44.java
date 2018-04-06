package question44;

public class q44 {
	public static void main(String[] args) {
		System.out.println(reverseStr("RaceCar"));
	}
	
	static String reverseStr(String str) {
		char arr[] = str.toCharArray();
		for(int i=0;i<arr.length/2;i++) {
			char z= arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=z;
		}
		System.out.println(arr);
		return "RaceCar";
	}
}

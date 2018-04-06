package question52;

public class q52 {

	public static void main(String[] args) {
		int num=123456789;
		String str = Integer.toString(num);
		int reverseNum=Integer.parseInt(reverseStr(str));
		System.out.println(reverseNum);
	}
	
	static String reverseStr(String str) {
		char arr[] = str.toCharArray();
		for(int i=0;i<arr.length/2;i++) {
			char z= arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=z;
		}
		return new String(arr);
	}

}

package advancedCodingExcercises;
// problem 44 - take the given string and reverse it without using the String API
public class ReverseString {
	char[] a; //opted to use char array
	String str = "Hello I am a String";
	
	public ReverseString() {
		reverse();
	}
	
	
	void reverse() {
		System.out.println("Entered String '" + str+"'");
		int length = str.length();
		a = new char[length];
		String arr[] = str.split("");
		for (int i = arr.length-1; i >= 0; i--) {  //for loops used to store string in reverse char by char
			 a = arr[i].toCharArray();
			for (int j = a.length-1; j >=0; j--) {
				System.out.print(a[j]);
			}
		}
	}
	
	public static void main(String[] args) {
		ReverseString t = new ReverseString();
	}
	
	
}

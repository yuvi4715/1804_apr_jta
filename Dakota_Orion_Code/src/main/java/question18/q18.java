package question18;

public class q18 {

	public static void main(String[] args) {
		String str1="234";
		String str2="34";
		System.out.println(addStrings(str1,str2));
		System.out.println(args);
	}
	
	static int addStrings(String...str) {
		int num1=0;
		int num2;
		for(String i:str) {
			num2 = Integer.parseInt(i);
			num1+=num2;
		}
		return num1;
	}

}

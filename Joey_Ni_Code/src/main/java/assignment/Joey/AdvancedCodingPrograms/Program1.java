package assignment.Joey.AdvancedCodingPrograms;
/**1. Write a method to replace a given character in a String with another character.
*/
public class Program1 {
	public static void main(String[] args) {
		System.out.println(replaceChar('o','e',"helloWorld"));
		System.out.println(replaceChar('1', 'L', "he11oWor1d"));
		
	}
	
	
	//replace old char c with new char n
	public static String replaceChar(char c, char n, String t) {
		//t.replace(c, n);
		char [] a= new char [t.length()]; //3
		int count=a.length-1;  //0,1,2
		for(int i =0; i<=count; i++)
		{
			if (t.charAt(i)==c) a[i]=n;
			else a[i]=t.charAt(i);			
		}
		
		return String.copyValueOf(a);
	}

}

package question38;

public class q38 {

	public static void main(String[] args) {
		String str = "hello";
		char c1= 'e';
		char c2= 'a';
		System.out.println(replaceChar(c1,c2,str));
	}
	
	static String replaceChar(char replace, char replaceBy, String str) {
		StringBuffer strBuff= new StringBuffer();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==replace) {
				strBuff.append(replaceBy);
			}
			else {
				strBuff.append(str.charAt(i));
			}
		}
		return strBuff.toString();
	}

}

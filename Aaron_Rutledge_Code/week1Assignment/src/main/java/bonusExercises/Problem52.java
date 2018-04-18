package bonusExercises;

public class Problem52 {
	
	
	public static void main(String[] args) {
		
		System.out.println(reverseInt(7331));
		
		
	}
	
	
	
	public static int reverseInt(int x) {
		
		Integer temp = x;
		
		String str = temp.toString();
		
		x = str.length();
		
		char [] cAry1 = str.toCharArray();
		
		char [] cAry2 = new char[x];
		
		for(int i = 0; i < x; i++) {
			
			cAry2[i] = cAry1[x-1-i];	
			
		}
		
		str = new String(cAry2);
		
		x = Integer.parseInt(str);
		
		return x;
		
		
		
		
	}
	
	
	

}

package question45;

public class q45 {
	public static void main(String[] args) {
		System.out.println(isPrime(99991));
	}
	
	static boolean isPrime(int num) {
		int x=(int) Math.sqrt(num);
		for(int i=2;i<=x;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}

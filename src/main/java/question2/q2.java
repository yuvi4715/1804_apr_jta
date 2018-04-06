package question2;

public class q2 {
	public static void main(String[] args) {
		int x =4;
		int y =20;
		int z =43;
		if(x>y&&y>z){
			System.out.println(x);
		}
		else if(y>x && y>z){
			System.out.println(y);
		}
		else{
			System.out.println(z);
		}
	}
}
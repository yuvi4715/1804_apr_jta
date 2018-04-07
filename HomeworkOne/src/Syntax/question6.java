package Syntax;

public class question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i<10; i++) {
			if (i == 5) {
				continue;
			} 
			if (i == 8) {
				break;
			}
			System.out.println(i);
		}
	}

}

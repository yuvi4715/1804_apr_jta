package arithmeticTest;

public class Control {
	//problem 7
	public static void main(String[] args) {
		
		int x = 5;
		int y = 27;
		int z = 0;
		
		if (x < y) {
			z = x + y;
		}
		
		while(x < y) {
			System.out.println(x);
			x++;
			if (x > 2) continue;
			else break;
		}
		
		do {
			y = y - 10;
		}
		while(y >= 30);
		
		for (int i = 0; i < x; i++) {
			z++;
		}
		
		switch(x) {
		case 1: 
			y = 1;
		case 2:
			y = 2;
		case 3:
			y = 4;
		case 4:
			y = 8;
		}
		
		
	}
}

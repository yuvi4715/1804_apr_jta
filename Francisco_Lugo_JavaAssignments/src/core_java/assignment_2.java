package core_java;

public class assignment_2 {

	public static void main(String[] args) {
		int x = 3;
		int y = 15;
		int z = 10;
		int greatest;
		
		if(x > y && x > z)
			greatest = x;
		else if (y > x && y > z)
			greatest = y;
		else
			greatest = z;
		
		System.out.println(greatest);

	}

}

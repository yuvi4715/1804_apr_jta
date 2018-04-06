package Bonus;

import java.util.LinkedList;

public class Problem47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList test = new LinkedList();
		for(int i = 0; i<5; i++)
			test.add(i);
		
		int middle = (test.size()/2);
		
		System.out.println(test.get(middle));
	}

}

package syntax3;

public class Problem6 {
	
	public static void main(String[] args) {
		
		boolean a = true;
		boolean b = false;
		int c = 0;
		int [] numAry = {2,4,6,8,10}; 
		
		
		if (a) {
			System.out.println("This statement always prints.");
		}
		
		if (b) {
			System.out.println("This statent never prints.");
		}
		
		
		
		
		
		if (b) {
			System.out.println("Since this block doesn't print, the next one should");
		}
		else {
			System.out.println("Since the if block didn't print, this block does.");
		}
		
		
		
		if (!a) {
			System.out.println("This statement doesn't print.");
		}
		else if (!b) {
			System.out.println("This statement prints.");
		}
		else {
			System.out.println("Control never reaches statement.");
		}
		
		switch (2) {
		case 1: 
			System.out.println("This case doesn't print");
			break;
		case 2: 
			System.out.println("This is the case, so it prints.");
		case 3: 
			System.out.println("The previous case didn't break, so this case prints too.");
			break;
		case 4: 
			System.out.println("This case doesn't print because the previous case breaks.");
			break;
		
		}
		
		while (c <= 5) {
			c++;
			System.out.println("This statement has printed " + c + " times.");
			
		}
 		
		do {
			
			System.out.println("This statement only printed because this is a do-while loop.");
			
		}while(b);
		
		for(int i = 0; i <= c; i++) {
			System.out.println("This statement has printed " + (i+1) + " times.");
			
			if (a) {
				continue;
			}

			System.out.println("This statement never prints, since it's after the continue");
			
		}
		
		for(int i : numAry ) {
			
			System.out.println("This statement has printed " + (i/2) + " times.");
			
		}
		
		
		
		
		
	}
	
	

}

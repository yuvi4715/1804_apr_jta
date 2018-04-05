package advanced.coding;


public class Questions {
	
	public static void main(String[] args) {
		
	//	question38("wooow woow jowk kol",'w','m');
	//	question41();
	//	question43(120);
	//	question45(97);
		question44(" what would you do for a klondike bar?");
		
	}
	
	public static void question38(String s, char oldChar, char newChar ) {
		
		System.out.println(s.replace(oldChar, newChar));
	}
	
	public static void question41() {
		
		for (int i =0; i<51; i++) {
			
			if (i%3 ==0 && i%5 == 0) {
				System.out.println("FizzBuzz");
				continue;
			}						
			
			if (i%3 == 0){
				System.out.println("Fizz");
				continue;
			}
			
			if (i%5 == 0){
				System.out.println("Buzz");
				continue;
			}else {
				System.out.println(i);
			}
			
			
			
			
			
		}
		
	}
	
	public static void question43(int n) {
		// I copied this method and modified it to make it dynamic
		int b =0;
		int a;
		int c = n;
		
		
		
	    while(n>0){
	              a=n%10;  n=n/10;  b=b+(a*a*a);
	              System.out.println(a+"  "+n+"  "+b);  
	            }
	    if(c==b)  System.out.println("Armstrong number");
	    else      System.out.println(" Not Armstrong number");
	    }
	
	public static void question44(String s) {
		
		//String s = "hello world";		
		String backwards = "";
        
        
        for(int i = s.length() - 1; i >= 0; i--) {
        	
            backwards = backwards + s.charAt(i);          
        }
        
		System.out.println(backwards);
	}
	
	
	public static String question45(int n) {
		
		
		for(int i = 2;i< n/2; i++ ) {
			
			if (n%i == 0) {
				System.out.println("Not Prime");
				return "";
			}			
			
		}
		System.out.println("Is prime");
		return"";
	}
	

}

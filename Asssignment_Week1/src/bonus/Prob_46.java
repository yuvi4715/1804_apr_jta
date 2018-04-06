package bonus;

public class Prob_46{
    
	public static void main(String args[]) {
        int x=5;
        int y=2;
        
        System.out.print("X = " + x + " ... Y = " + y);
        
        x = x*y; //5 x 2 = 10
        y = x/y; //10 / 2 = 5
        x = x/y; //10 / 5 = 2
        
        System.out.println();
        System.out.print("X = " + x + " ... Y = " + y);
    }
}
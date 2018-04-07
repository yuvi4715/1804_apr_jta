package assignment.Joey;
/**a program –declare two variables a & b and initialize them to true 
 * and false respectively. Get the output of the following computations:
                !a
                a | b    
                (!a & b) | (a & !b)

 *@author Joey Ni
 *
*/
public class CoreJava3 {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		System.out.println("Output of !a is "+ !a );
		System.out.println("Output of a | b is " + (a || b));
		System.out.println("Output of (!a & b) | (a & !b) is " + ((!a && b) || (a && !b)));
	}
}

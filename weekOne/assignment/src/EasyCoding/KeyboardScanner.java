package EasyCoding;
import java.util.Scanner;
/**
 * Created by bryanvillegas on 4/4/18.
 */
public class KeyboardScanner{
    public static void main(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an int");
        int i = reader.nextInt();
        System.out.print("Enter a double");
        double d = reader.nextDouble();
        System.out.print("Enter a String");
        String s = reader.next();

        System.out.println("You entered int " + i);
        System.out.println("You entered double " + d);
        System.out.println("You entered string " + s);



    }
}

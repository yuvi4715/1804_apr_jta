package AdvancedCoding;
import java.util.Scanner;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class ReplaceChar {

    public static void main(){
        StringBuilder hi = new StringBuilder("Hello world");
        System.out.println("Type what char to replace");
        System.out.println("Hello world");

        Scanner scan = new Scanner(System.in);
        String letter = scan.next();
        System.out.println("Type what char to replace with");
        String replace = scan.next();
        hi.insert(hi.indexOf(letter), replace);
        System.out.println(hi);



    }
}

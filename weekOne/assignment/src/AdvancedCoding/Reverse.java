package AdvancedCoding;

/**
 * Created by bryanvillegas on 4/5/18.
 */
public class Reverse {

    public static void main(String[] args){

        String a = "Hello, World!";
        String b = "";
        for(int i = a.length() - 1; i >= 0; i-- ){
            b += a.charAt(i);
        }
        System.out.println(b);

    }
}

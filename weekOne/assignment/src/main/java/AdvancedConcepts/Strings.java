package AdvancedConcepts;

import java.util.StringTokenizer;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class Strings {
    public static void main(String[] args){

        //16
        StringBuilder s1 = new StringBuilder("Hello, World");
        s1.append("!!!");
        System.out.println(s1);
        System.out.println(s1.substring(0,5));
        s1.reverse();
        System.out.println(s1);


        //17
        String s2 = "pickles:ketchup:mustard:onion";
        StringTokenizer tok = new StringTokenizer(s2, ":");
        while(tok.hasMoreTokens()) {
            System.out.println(tok.nextToken());
        }

        addStrings();


        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        runtime.freeMemory();
        runtime.availableProcessors();


    }
    //18
    public static void addStrings(){
        String s1 = "20";
        String s2 = "5";

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);

        System.out.println(i1+i2);
    }
}

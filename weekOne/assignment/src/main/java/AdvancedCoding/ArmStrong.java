package AdvancedCoding;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bryanvillegas on 4/5/18.
 */
public class ArmStrong {

    public static void main(String[] args){

        checkArmstrong();
    }

    public static void checkArmstrong(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String line;
        line = in.next();
        int num = Integer.parseInt(line);
        int sum = 0;
        int len = line.length();

        while(line.length() > 0){
            char c = line.charAt(0);
            line = line.substring(1);
            sum += Math.pow(Integer.parseInt(c+""), len);
        }
        if(sum == num)
            System.out.println("Its an Armstrong number");
        else
            System.out.println("Its not an Armstrong number");

    }
}

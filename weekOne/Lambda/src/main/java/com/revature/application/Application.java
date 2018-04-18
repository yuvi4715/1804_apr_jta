package com.revature.application;

/**
 * Created by bryanvillegas on 4/10/18.
 */
import fi.Math;
public class Application {
    public static void main(String[] args){
        Math add = (a, b) -> a + b;
        Math multiply = (int x, int y) -> x * y;
        Math divide = (first, second) -> {
            if(second == 0)
                return 0;
            return first / second;
        };


    }
}

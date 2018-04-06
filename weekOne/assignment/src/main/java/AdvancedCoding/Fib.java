package AdvancedCoding;
import java.math.BigInteger;
import java.util.*;

public class Fib {

    public static void main(String[] args){

        //fibs();
        System.out.println(recFib(100));
        System.out.println("Done");

    }

    public static void fibs(){
        BigInteger[] cache = new BigInteger[101];

        cache[0] = BigInteger.ZERO;
        cache[1] = BigInteger.ONE;

        for(int i = 2; i < 100; i++){
            cache[i] = cache[i - 1].add(cache[i - 2]);
        }
        System.out.println(cache[99]);
    }

    public static BigInteger recFib(int n){
        BigInteger[] cache = new BigInteger[100];
        cache[0] = BigInteger.ZERO;
        cache[1] = BigInteger.ONE;

        BigInteger result;

        if(n == 0)
            return cache[0];
        else if(n == 1)
            return cache[1];
        else if(cache[n] != null){
            return cache[n];
        }

        result = recFib(n - 1).add(recFib(n -2));
        cache[n] = result;
        return result;


    }
}

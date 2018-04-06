package AdvancedCoding;


public class FizzBuzz {

    public static void main(String[] args){
        fizzbuzz(50);
    }

    public static void fizzbuzz(int n){

        for(int i = 1; i <= n; i++){

            System.out.println(i);
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
        }

    }
}

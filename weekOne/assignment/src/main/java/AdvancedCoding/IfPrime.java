package AdvancedCoding;

/**
 * Created by bryanvillegas on 4/5/18.
 */
public class IfPrime {
    public static void main(String[] args){

        ifPrime(200000);

    }
    public static void ifPrime(int n){
        if(n % 2 == 0){
            System.out.println("Not Prime");
            return;
        }
        else if(n % 3 == 0){
            System.out.println("Not Prime");
            return;
        }

        for(int i = 4; i < n;i++){
            if(i % n == 0){
                System.out.println("Not Prime");
                return;
            }

        }
        System.out.println("The number is Prime");
    }
}

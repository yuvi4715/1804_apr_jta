package Syntax;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class ControlSta {
    public static void main(String[] args){
        int a = 3;
        if(a < 4){
            System.out.println("A is less than 3");
        }
        else{
            System.out.println("A is greater than 3");
        }
        switch(a){
            case 0:
                System.out.println("Zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
        }
        for(int i = 0; i < 5; i++){
            System.out.println("Hello, World!");
        }
        while(a > 0){
            System.out.println("Hello, World!");
            a--;
        }

        a = 3;

        do{
            System.out.println("Hello, World!");
            a--;
        }while(a > 0);

        a = 3;
        while(a > 0){
            if(a == 1)
                break;
            a--;
        }

        a = 3;

        while(a > 0){
            if(a == 1)
                continue;
            a--;
        }

    }
}

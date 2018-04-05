package EasyCoding;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class Arithmetic {

    public static void main(String[] args){
        String first = "";
        String second= "";
        String third = "";
        int num1,num2;

        if(args.length > 0){
            first = args[0];
            second = args[1];
            third = args[2];

        }

        num1 = Integer.parseInt(first);
        num2 = Integer.parseInt(second);

        if(third.equals("+"))
            System.out.println(num1 + num2);
        else if(third.equals("-"))
            System.out.println(num1 - num2);
        else if(third.equals("*"))
            System.out.println(num1 * num2);
        else if(third.equals("/"))
            System.out.println(num1 % num2);




    }
}

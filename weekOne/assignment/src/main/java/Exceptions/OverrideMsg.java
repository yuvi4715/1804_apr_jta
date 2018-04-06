package Exceptions;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class OverrideMsg extends Exception {

    public String getMessage(boolean a){
            return "WARNING";
    }

    public static void main(String[] args){
        OverrideMsg ex = new OverrideMsg();
        System.out.println(ex.getMessage(true));
    }



}

package Exceptions;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class TestCust extends Exception{

    public static void main(String[] args){

        System.out.println("Try block is starting");
        try{
            pullCord();

            System.out.println("Try block is ending");

        }
        catch(OverrideMsg e){
            System.out.println("Catch block is starting");
            e.getMessage();
            System.out.println("Catch block is ending");

        }
        finally{
            System.out.println("Goodbye");
        }

    }
    public static void pullCord() throws OverrideMsg{
        if(true){
            throw new OverrideMsg();
        }
    }
}

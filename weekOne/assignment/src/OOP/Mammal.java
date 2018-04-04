package OOP;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public abstract class Mammal implements Animal{


    public void eat() {
        System.out.println("Mammals eat");

    }

    public static void walk() {
        System.out.println("Mammals walk");

    }
    public void move(){};
}

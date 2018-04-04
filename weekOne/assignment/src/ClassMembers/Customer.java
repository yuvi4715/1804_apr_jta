package ClassMembers;

/**
 * Created by bryanvillegas on 4/3/18.
 */
public class Customer {
    final double tax = .7;
    static int amount;

    Customer(){

    }
    Customer(int x){
        amount += x;

    }

    static void method1() {}
    static void method2() {}
    public void method1(int x) {}
    public void method2(int x) {}

}

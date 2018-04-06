package CoreJava;

/**
 * Created by bryanvillegas on 4/3/18.
 */
public class ThreeNums {
    public void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        int num3 = 15;

        if(num1 > num2) {
            if(num1 > num3) {
                System.out.println(num1);
            }
            else {
                System.out.print(num3);
            }
        }
        else if(num2 > num3) {
            System.out.println(num2);
        }
        else {
            System.out.println(num3);
        }
    }
}

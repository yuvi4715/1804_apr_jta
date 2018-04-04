package OOP;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class Human extends Mammal {

    public void eat(){
        System.out.println("Humans eat");
    };
    public static void walk(){
        System.out.println("Humans walk");
    };

    public static void main(String[] args){
        Animal one = new Human();
        Mammal two = new Human();
        Human three = new Human();

        one.eat();
        one.move();
        two.eat();
        two.move();
        two.walk();
        three.eat();
        three.move();
        three.walk();
    }
}

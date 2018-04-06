package Collections;

import java.util.*;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class Collection {

    public static void main(String[] args) {
        Integer num1 = 1;
        Integer num2 = 2;
        Integer num3 = 3;

        ArrayList<Integer> al = new ArrayList<Integer>(3);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();

        al.add(num1);
        al.add(num2);
        al.add(num3);

        ll.add(num1);
        ll.add(num2);
        ll.add(num3);

        ts.add(num1);
        ts.add(num2);
        ts.add(num3);

        hs.add(num1);
        hs.add(num2);
        hs.add(num3);

        for (Integer integer : al) {
            System.out.println(integer);
        }

        //ll.forEach(System.out::println);
        //ts.forEach(System.out::println);
        //hs.forEach(System.out::println);

        Collections.sort(al);
        Collections.sort(ll);



    }

}

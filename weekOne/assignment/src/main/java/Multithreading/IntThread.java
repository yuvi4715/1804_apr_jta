package Multithreading;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class IntThread extends Thread {

    static volatile int i = 0;

    public void run(){

        for(int i = 0; i < 1000; i++){
            incr();

        }

    }

    public static void main(String[] args){
        Thread t1 = new IntThread();
        Thread t2 = new IntThread();
        Thread t3 = new IntThread();

        t1.start();
        t2.start();
        t3.start();




    }

    public synchronized int incr(){
        System.out.println(Thread.currentThread().getName() + " : " + i);
        return i++;
    }


}

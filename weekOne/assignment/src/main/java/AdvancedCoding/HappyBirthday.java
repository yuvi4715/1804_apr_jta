package AdvancedCoding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by bryanvillegas on 4/5/18.
 */
public class HappyBirthday {

    public static void main(String[] args){

        Date date = new Date();
        Calendar now = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        now.setTime(date);

        birthday.set(1990,3,5);
        //System.out.println(now.compareTo(birthday));

        long end = now.getTimeInMillis();
        long start = birthday.getTimeInMillis();

        long numDays = TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
        int age = (int)(numDays/365);

        System.out.println(now.get(Calendar.DATE));
        System.out.println(birthday.get(Calendar.MONTH));

        if(now.get(Calendar.MONTH) == birthday.get(Calendar.MONTH) && now.get(Calendar.DATE) == birthday.get(Calendar.DATE))
            System.out.println("Happy Birthday!!");
        System.out.println("Your age: " + age);


    }
}

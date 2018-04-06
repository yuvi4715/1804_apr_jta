package EasyCoding;

import java.awt.*;
import java.util.*;

/**
 * Created by bryanvillegas on 4/4/18.
 */
public class GradesStatistics {
    public static void main(String[] args){
        ArrayList<Integer> grades = new ArrayList<Integer>();

        System.out.println("Input grades and type -1 to finish");
        Scanner input = new Scanner(System.in);
        int grade;
        double average = 0, standardDev = 0;
        double powerSum1 = 0, powerSum2 = 0;
        int minimum, maximum;
        int total = 0;

        do{
            grade = input.nextInt();
            if(grade != -1 && grade <= 100 && grade >= 0)
                grades.add(grade);

        }while(grade != -1);

        for(int i = 0; i < grades.size(); i++){
            total += grades.get(i);

        }
        average = (double)total/grades.size();
        Collections.sort(grades);
        total = 0;
        minimum = grades.get(0);
        maximum = grades.get(grades.size() - 1);

        double[] std = new double[grades.size()];
        for(int i = 0; i < grades.size(); i++){
            std[i] = Math.pow(grades.get(i) - average,2);

        }
        for(int i = 0; i < grades.size(); i++){
            total += std[i];

        }
        standardDev = total/grades.size();
        standardDev = Math.sqrt(standardDev);


        System.out.println("Average: " + average);
        System.out.println("Minimum: " + minimum);
        System.out.println("Maximum: " + maximum);
        System.out.println("Standard Dev: " + standardDev);









    }
}

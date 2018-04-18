package com.revature.Homework.ProblemFourtyTwo;

import java.util.Comparator;

class SortByAge implements Comparator<Employee>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee a, Employee b)
    {
        return (int) (a.getAge()-b.getAge());
    }
    
    
}

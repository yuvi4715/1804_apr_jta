package com.revature.Homework.ProblemFourtyTwo;

import java.util.Comparator;

class SortByID implements Comparator<Employee>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee a, Employee b)
    {
        return (int) (a.getId()-b.getId());
    }
}

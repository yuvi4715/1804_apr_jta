package com.revature.Homework.ProblemFourtyTwo;

import java.util.Comparator;

class SortByDepartment implements Comparator<Employee>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Employee a, Employee b)
    {
        return a.getDepartment().compareTo(b.getDepartment());
    }
}

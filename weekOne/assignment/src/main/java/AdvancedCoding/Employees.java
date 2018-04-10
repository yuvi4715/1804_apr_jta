package AdvancedCoding;


/**
 * Created by bryanvillegas on 4/5/18.
 */
public class Employees {

    String firstName, lastName, role, department;
    int id, age;

    public Employees(String f, String l, String r, String d, int i, int a){
        this.firstName = f;
        this.lastName = l;
        this.role = r;
        this.department = d;
        this.id = i;
        this.age = a;
    }
}

class sortAge implements Comparable<Employees>{
    public int compare(Employees a, Employees b){
        return (int)(a.age - b.age);
    }

   // @Override
    public int compareTo(Employees o) {
        return 0;
    }
}

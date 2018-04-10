package question42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class q42 {

	public static void main(String[] args) {
		ArrayList<Employees> em = new ArrayList<Employees>();
		em.add(new Employees("John","Sales",15));
		em.add(new Employees("Jimmy","Sales",5));
		em.add(new Employees("Superman","News",78));
		System.out.println("Unsorted");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i).name);
        }
 
        Collections.sort(em, new SortbyAge());
 
        System.out.println("Sorted by Age");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i).name);
        }
 
        Collections.sort(em, new SortbyName());
 
        System.out.println("Sorted by Name");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i).name);
        }
	}
}

class SortbyAge implements Comparator<Employees>
{
    public int compare(Employees a, Employees b)
    {
        return a.age - b.age;
    }
}
 
class SortbyName implements Comparator<Employees>
{
    public int compare(Employees a, Employees b)
    {
        return a.name.compareTo(b.name);
    }
}
package question42;

import java.util.StringTokenizer;

public class q42 {

	public static void main(String[] args) {
		ArrayList<Employees> em = new ArrayList<Employees>();
		em.add(new Employees("John","Sales",15));
		em.add(new Employees("Jimmy","Sales",5));
		em.add(new Employees("Superman","News",78));
		System.out.println("Unsorted");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i));
        }
 
        Collections.sort(em, new SortbyAge());
 
        System.out.println("Sorted by Age");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i));
        }
 
        Collections.sort(em, new Sortbyname());
 
        System.out.println("Sorted by Name");
        for (int i=0; i<em.size(); i++){
            System.out.println(em.get(i));
        }
	}
}

public class SortbyAge implements Comparator<Student>
{
    public int compare(Employees a, Employees b)
    {
        return a.age - b.age;
    }
}
 
public class Sortbyname implements Comparator<Student>
{
    public int compare(Employees a, Employees b)
    {
        return a.name.compareTo(b.name);
    }
}
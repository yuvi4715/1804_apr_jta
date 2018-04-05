import java.util.*;

public class ComparingExample {
	public static void main(String[] args) {
		//List<Duck> ducks = new ArrayList<>();
		//ducks.add(new Duck(150, "Puddles"));
		//ducks.add(new Duck(35, "Quack"));
		//ducks.add(new Duck(100, "Albert"));
		//Collections.sort(ducks);
		//System.out.println(ducks);
		
		List<MultiSortableDuck> ducks = new ArrayList<>();
		ducks.add(new MultiSortableDuck(35, "Albert"));
		ducks.add(new MultiSortableDuck(35, "Bertha"));
		ducks.add(new MultiSortableDuck(150, "Quack"));
		ducks.add(new MultiSortableDuck(100, "Zedd"));
		Collections.sort(ducks, new ComparingMultipleDucks());
		System.out.println(ducks);
	}
}

class Duck implements Comparable<Duck>{
	private int weight;
	private String name;
	
	public Duck(int weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	@Override 
	public String toString() {
		return "[Name= " + name + ", Weight= " + weight + "]";
	}
	
	/*public int compareTo(Duck other) {
		return this.weight - other.weight;
	}*/
	
	public int compareTo(Duck other) {
		return this.getName().compareTo(other.getName());
	}
}

class MultiSortableDuck {
	private int weight;
	private String name;
	
	public MultiSortableDuck(int weight, String name) {
		this.weight = weight;
		this.name = name;
	}
	
	public int getWeight() { return this.weight; }
	
	public String getName() { return this.name; }
	
	@Override 
	public String toString() {
		return "[Name= " + name + ", Weight= " + weight + "]";
	}
}

class ComparingMultipleDucks implements Comparator<MultiSortableDuck> {
	public int compare(MultiSortableDuck d1, MultiSortableDuck d2) {
		int result = d2.getWeight() - d1.getWeight();
		if (result != 0) return result;
		return d2.getName().compareTo(d1.getName());
	}
}
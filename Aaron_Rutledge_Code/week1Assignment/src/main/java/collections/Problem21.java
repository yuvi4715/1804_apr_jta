package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Problem21 {
	
	
	public static void main(String[] args) {
		
		Pokemon one = new Pokemon(1, "Bulbasaur", "Grass", "Poison");
		Pokemon two = new Pokemon(6, "Charizard", "Fire", "Flying");
		Pokemon three = new Pokemon(25, "Pikachu", "Electric", "Null");
		
		ArrayList<Pokemon> pkmnAL = new ArrayList<>();
		LinkedList<Pokemon> pkmnLL = new LinkedList<>();
		HashMap<Integer, Pokemon> pkmnHM = new HashMap<>();
		TreeSet<Pokemon> pkmnTS = new TreeSet<>();
		HashSet<Pokemon> pkmnHS = new HashSet<>();
		
		Integer key1 = 1;
		Integer key2 = 2;
		Integer key3 = 3;
		
		pkmnAL.add(one);
		pkmnAL.add(two);
		pkmnAL.add(three);
		
		pkmnLL.add(one);
		pkmnLL.add(two);
		pkmnLL.add(three);
		
		pkmnHM.put(key1, one);
		pkmnHM.put(key2, two);
		pkmnHM.put(key3, three);
		
		pkmnTS.add(one);
		pkmnTS.add(two);
		pkmnTS.add(three);
		
		pkmnHS.add(one);
		pkmnHS.add(two);
		pkmnHS.add(three);
		
		
		}

}




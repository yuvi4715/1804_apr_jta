package collections;

public class Pokemon implements Comparable<Pokemon>{
	
	private int id;
	private String name;
	private String type1;
	private String type2;
	private int lvl;
	
	public Pokemon() {
		
		this.id = 0;
		this.name = "MissingNo.";
		this.type1 = "Null";
		this.type2 = "Null";
		this.lvl = 255;		
		
	}

	public Pokemon(int id, String name, String type1, String type2) {
		
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.lvl = 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", lvl=" + lvl + "]";
	}

	
	public int compareTo(Pokemon arg0) {
		// TODO Auto-generated method stub
		return (this.getId() - arg0.getId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

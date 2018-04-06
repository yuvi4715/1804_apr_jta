package advancedConcepts;
// problem 15
public class AStringBuilderObject {
	StringBuilder l = new StringBuilder();
	
	public AStringBuilderObject() {
		addChar();
		System.out.println(l.toString());
		deleteChar();
		System.out.println(l.toString());
		insert();
		System.out.println(l.toString());
	}
	
	void addChar() {  //append some characters to builder
		l.append("help");
		
	}
	
	void deleteChar() { //delete character at index 1
		l.deleteCharAt(1);
	}
	
	void  insert() {  
		l.reverse(); // reverses characters in the stringbuilder
	}
	
	public static void main(String[] args) {
		AStringBuilderObject t = new AStringBuilderObject();
	}
	
}

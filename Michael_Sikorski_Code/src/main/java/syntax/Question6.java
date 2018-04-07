package syntax;

public class Question6 {

	// if, switch, for, while, do-while,

	public Question6() {
		
	}

	public String ifStatement() {
		boolean isAnIfStatement = true;
		if (isAnIfStatement) {
			return "This is an if statement";
		} else 
			return "This is not an if statement";
	}
	
	public String switchStatement(String s) {
		switch(s) {
		case "switch":
			return "This is a switch statement";
		default:
			return "This is not a switch statement";
		}
	}
	
	public String forLoop() {
		String result = "";
		String[] words = {"This","is","a","for","loop"};
		for (String w : words) {
			result += w + " ";
		}
		return result;
	}
	
	public String whileLoop() {
		String result = "";
		String[] words = {"This","is","a","while","loop"};
		int iterator = 0;
		while (iterator < words.length) {
			result += words[iterator] + " ";
			iterator++;
		}
		return result;
	}
	
	public String doWhileLoop() {
		do {
			return "This is a do while loop";
 		} while (false);
	}
}

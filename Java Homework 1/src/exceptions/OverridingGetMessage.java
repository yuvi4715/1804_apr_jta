package exceptions;
// Problem 10  -  a simple class overiding the getMessage method.
public class OverridingGetMessage extends Exception {
		
	// serialization
	private static final long serialVersionUID = -5990853197261620861L;
	
		public OverridingGetMessage() {
			super();
		}
		public String getMessage() {
			return "Sup dude, I overrided the getMessage() method. You mad, bro?";
		}
	
		public static void main(String[] args) {
			OverridingGetMessage t = new OverridingGetMessage();
			System.out.println(t.getMessage());
		}

}

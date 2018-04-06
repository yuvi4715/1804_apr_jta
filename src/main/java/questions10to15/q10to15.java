package questions10to15;

public class q10to15 {
	public static void main(String[] args) {
		try {
			//System.exit(0);
			System.out.println("Start try block");
			//System.exit(0);
			exException(1);
			//System.exit(0);
			System.out.println("End try block");
		} catch (MyException ex) {
			System.out.println("Start catch block");
			ex.printStackTrace();
		} 
		finally{
			System.out.println("Goodbye");
		}
	}
	
	static String exException(int i) throws MyException {
		if(i==1) {
			System.out.println("Throwing MyException");
			throw new MyException();
		}
		else {
			return "success";
		}
	}

}

package question29to31;

public class SycronizedIncrementedInteger{
	private static int i=0;
	
	public static int getI() {
		return i;
	}

	public synchronized static int increment() {
		i++;
		return i;
	}
}

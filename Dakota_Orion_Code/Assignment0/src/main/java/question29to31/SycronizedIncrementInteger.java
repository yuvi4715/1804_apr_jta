package question29to31;

public class SycronizedIncrementInteger{
	private int i=0;
	
	public synchronized int getI() {
		return i;
	}

	public synchronized int increment() {
		i++;
		return i;
	}
}

package question20;

public class q20 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.totalMemory());
		System.out.println(rt.maxMemory());
		rt.availableProcessors();
	}

}

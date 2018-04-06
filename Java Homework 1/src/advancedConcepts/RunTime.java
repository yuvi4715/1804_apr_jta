package advancedConcepts;
//problem 20 **not done yet**

public class RunTime{
	
	
	public RunTime() {
		doTheThingy();
		
	}
	
	void doTheThingy() {
		System.out.println("Program Starting");
		
		Runtime run = Runtime.getRuntime();
		System.out.println("At runtime some methods can be considered");
		System.out.println("First, I would use the method availibleProcessors() to return the number of processors availible.");
		System.out.println("So I have :" + run.availableProcessors());
		
		System.out.println("When I need to, i would use the freeMemory() method to get the amount of free memory remaining.");
		System.out.println("" + run.freeMemory());
		
		System.out.println("There are also times where I would just want to determine the maximum memory allocated to the JVM"
				+ " I would just used the maxMemor() method.");
		System.out.println("Maximum memory is: " + run.maxMemory() + " Bytes");
	}
	
	
	public static void main(String[] args) {
		RunTime t = new RunTime();
		
	}
}

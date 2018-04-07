package advancedConceptsQuestions20;

import java.io.PrintStream;


//Create a Runtime object and note at least three methods. 
//Imagine how you would use them.


public class AdvancedConceptsQuestions20 
{
	public static void main(String[] args) 
	{
		RuntimeObjectTest(System.out);
    }

		public static void RuntimeObjectTest(PrintStream out)
		{
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
			out.println(runtime.totalMemory());
			out.println(runtime.availableProcessors());
			out.println(runtime.freeMemory());
			out.println(runtime.maxMemory());
			out.println(Runtime.getRuntime());
		}
	
	
}


package bonusExercices;
/**
 * Dominick Sermeno
 * Batch 1804
 * BQ's: 49
 */
public class SubString 
{

	public static void main(String[] args)
	{
		 String str= new String("Today I went out to eat, with my friend who came over.");
		 System.out.println(str);
		 /////Example one////////////////
		 System.out.println("Substring starting from index 0 and ending at 24:");
	     System.out.println(str.substring(0, 24));
	     ///////////////////////////////
	     //////Example two////////////////
	     System.out.println("Substring starting from index 24:");
	     System.out.println(str.substring(24));
	    //////////////////////////////////
	}

}

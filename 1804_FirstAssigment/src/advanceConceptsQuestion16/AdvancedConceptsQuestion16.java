package advanceConceptsQuestion16;

import java.io.PrintStream;

//Create a StringBuilder object. 
//Use at least three methods to manipulate the String.


public class AdvancedConceptsQuestion16 
{

		public static void main(String[] args) 
		{
			Test1(System.out);
		}
		
		public static void Test1(PrintStream out)
		{
			String pokemon = "Pikachu";
			StringBuilder PokemonBuilder = new StringBuilder(pokemon);
			PokemonBuilder.append("Pika-Pika Pikachu!");
			PokemonBuilder.deleteCharAt(3);
			PokemonBuilder.setLength(8);
			PokemonBuilder.indexOf(pokemon, 2);
			out.println(PokemonBuilder.toString());
		}
	
	
	
}

package com.revature.exceptions;

public class ExceptionApp {

	// Question 11
	public static void main(String[] args) {
		ExceptionApp exceptionApp = new ExceptionApp();
//		exceptionApp.marvelCharacterString("Batman");
//		exceptionApp.marvelCharacterString("Ethan Hunt");
//		exceptionApp.marvelCharacterString("Marvel Luke Cage");
		
		try {
			System.out.println(exceptionApp.comicsAreCool("Batman"));
		}
		catch (NonMarvelCharacterException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	public boolean isMarvelCharacter(String character) throws NonMarvelCharacterException {
		if (character.contains("Marvel")) {
			return true;
		} else {
			throw new NonMarvelCharacterException();
		}
	}
	
	// Question 13
	public boolean comicsAreCool(String character) throws NonMarvelCharacterException {
		System.out.println("Comics are cool!");
		return isMarvelCharacter(character);
		
	}
	
	// Question 12
	public void marvelCharacterString(String character) {
		try {
			System.out.println("=====>>Trying isMarvelCharacter");
			if (isMarvelCharacter(character)) {
				System.out.println("=====>>Ending Try Block");
				System.out.println("It's a Marvel Character!!");
			} else {
				System.out.println("Ending Try Block");
				System.out.println("That ain't Marvel!!");
			} // Question 15
			System.exit(0);
		}
		catch (NonMarvelCharacterException e) {
			System.out.println("=====>>Catching NonMarvelCharacterException");
			System.out.println("=====>>Exception Message: " + e.getMessage());
		} // Question 14
		finally {
			System.out.println("=====>> Exiting Gracefully");
		}
	}

}

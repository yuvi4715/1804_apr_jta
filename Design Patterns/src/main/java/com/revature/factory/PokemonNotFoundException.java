package com.revature.factory;

public class PokemonNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 925607534058303810L;

//	public String getMessage() {
//		return "Pokemon does not exist";
//	}
	
	public PokemonNotFoundException(String msg) {
		super(msg);
	}
}

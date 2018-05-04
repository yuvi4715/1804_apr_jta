package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoHibernate;
import com.revature.dao.PokemonTrainerDao;
import com.revature.dao.PokemonTrainerDaoHibernate;
import com.revature.dao.PokemonTypeDao;
import com.revature.dao.PokemonTypeDaoHibernate;
import com.revature.model.Pokemon;
import com.revature.model.PokemonTrainer;
import com.revature.model.PokemonType;

public class Main {
	public static void main(String[] args) {
		PokemonTypeDao pokemonTypeDao = new PokemonTypeDaoHibernate();
		PokemonDao pokemonDao = new PokemonDaoHibernate();
		PokemonTrainerDao pokemonTrainerDao = new PokemonTrainerDaoHibernate();

		pokemonTypeDao.insert(new PokemonType(0,"GRASS"));
		pokemonTypeDao.insert(new PokemonType(0,"FIRE"));
		pokemonTypeDao.insert(new PokemonType(0,"WATER"));

		//Trainer
		PokemonTrainer ash = new PokemonTrainer(0,"ASH",17,null);
		PokemonTrainer gary = new PokemonTrainer(0,"GARY",19,null);
		pokemonTrainerDao.insert(ash);
		pokemonTrainerDao.insert(gary);
		
		//Pokemon
		Pokemon bulbasaur = new Pokemon(
				0,
				"BULBASAUR",
				1,
				pokemonTypeDao.selectByName(new PokemonType("GRASS")),
				new Pokemon(
						0,
						"IVYSAUR",
						2,
						pokemonTypeDao.selectByName(new PokemonType("GRASS")),
						new Pokemon(
								0,
								"VENASAUR",
								3,
								pokemonTypeDao.selectByName(new PokemonType("GRASS")),
								null
								)
						)
				);
		pokemonDao.insert(bulbasaur);

		Pokemon charmander = new Pokemon(
				0,
				"CHARMANDER",
				4,
				pokemonTypeDao.selectByName(new PokemonType("FIRE")),
				new Pokemon(
						0,
						"CHARMELEON",
						5,
						pokemonTypeDao.selectByName(new PokemonType("FIRE")),
						new Pokemon(
								0,
								"CHARIZARD",
								6,
								pokemonTypeDao.selectByName(new PokemonType("FIRE")),
								null
								)
						)
				);
		pokemonDao.insert(charmander);

		Pokemon squirtle = new Pokemon(
				0,
				"SQUIRTLE",
				7,
				pokemonTypeDao.selectByName(new PokemonType("WATER")),
				new Pokemon(
						0,
						"WARTORTLE",
						8,
						pokemonTypeDao.selectByName(new PokemonType("WATER")),
						new Pokemon(
								0,
								"BLASTOISE",
								9,
								pokemonTypeDao.selectByName(new PokemonType("WATER")),
								null
								)
						)
				);
		pokemonDao.insert(squirtle);
		
		//Update pokemons owned
		List<Pokemon> pokemonOwned = new ArrayList<>();
		pokemonOwned.add(bulbasaur);
		pokemonOwned.add(charmander);
		pokemonOwned.add(squirtle);
		ash.setPokemonOwned(pokemonOwned);
		pokemonTrainerDao.update(ash);
		
		pokemonOwned = new ArrayList<>();
		pokemonOwned.add(charmander);
		gary.setPokemonOwned(pokemonOwned);
		pokemonTrainerDao.update(gary);
		
		//Pokemon
		System.out.println("ALL POKEMON:" + pokemonDao.selectAll());
		System.out.println("SELECTED BY NAME:" + pokemonDao.selectByName(new Pokemon("venasaur")));
		System.out.println("SELECT BY TYPE"+ pokemonDao.selectByType(
				pokemonTypeDao.selectByName(
						new PokemonType("grass"))));
		System.out.println("SELECT BY CRITERIA" + pokemonDao.selectByNameCriteria("I%"));
		
		//Trainer
		ash = pokemonTrainerDao.selectByName(new PokemonTrainer("ASH"));
		System.out.println("PRINT TRAINER (NOT USING POKEMONS OWNED" + ash);
		System.out.println("ABOUT TO USE POKEMONS OWNED");
		System.out.println("POKEMONS OWNED BY ASH: " + ash.getPokemonOwned());
		
		//Who owns a pokemon
		//We need to update the values inside Pokemon as well regarding trainers
		bulbasaur = pokemonDao.selectByName(new Pokemon("bulbasaur"));
		charmander = pokemonDao.selectByName(new Pokemon("charmander"));
		squirtle = pokemonDao.selectByName(new Pokemon("squirtle"));
		System.out.println("TRAINERS THAT OWN BULBASAUR: " + bulbasaur.getTrainersThatOwn());
		System.out.println("TRAINERS THAT OWN CHARMANDER: " + charmander.getTrainersThatOwn());
		System.out.println("TRAINERS THAT OWN SQUIRTLE: " + squirtle.getTrainersThatOwn());
	}
}

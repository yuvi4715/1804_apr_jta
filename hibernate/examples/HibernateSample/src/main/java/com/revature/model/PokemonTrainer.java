package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="POKEMON_TRAINER")
public class PokemonTrainer {
	
	@Id
	@GeneratedValue
	@Column(name="PTR_ID")
	private int id;
	
	@Column(name="PTR_NAME")
	private String name;
	
	@Column(name="PTR_AGE")
	private int age;
	
	/* Many to many relationship, pokemon uses mappedBy and this field.*/
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Pokemon> pokemonOwned;
	
	public PokemonTrainer() {}
	
	public PokemonTrainer(String name) {
		this.name = name;
	}

	public PokemonTrainer(int id, String name, int age, List<Pokemon> pokemonOwned) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.pokemonOwned = pokemonOwned;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Pokemon> getPokemonOwned() {
		return pokemonOwned;
	}

	public void setPokemonOwned(List<Pokemon> pokemonOwned) {
		this.pokemonOwned = pokemonOwned;
	}

	/* Not showing pokemons owned in order to show lazy loading */
	@Override
	public String toString() {
		return "PokemonTrainer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

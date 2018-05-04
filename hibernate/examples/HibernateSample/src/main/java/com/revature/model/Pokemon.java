package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="POKEMON",
uniqueConstraints = { @UniqueConstraint( columnNames = { "P_NAME"} ) })
public class Pokemon {
	
	@Id
	@GeneratedValue
	@Column(name="P_ID")
	private int id;
	
	@Column(name="P_NAME")
	private String name;
	
	@Column(name="P_NUMBER")
	private int number;
	
	/* Regular one to one Relationship */
	@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="FOREIGN_KEY")
	private PokemonType type;
	
	/* Hierarchical Relationship */
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Pokemon evolution;
	
	/* Many to Many relationship, mapping field in Trainer */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "pokemonOwned")
	private List<PokemonTrainer> trainersThatOwn;
	
	/*For one to many */
	/*
	 * @OneToMany(fetch = FetchType.EAGER)
	 * private Set<PokemonType> type;
	 */
	
	public Pokemon() {}
	
	public Pokemon(String name) {
		this.name = name;
	}

	public Pokemon(int id, String name, int number, PokemonType type, Pokemon evolution) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
		this.evolution = evolution;
	}
	
	public Pokemon(int id, String name, int number, PokemonType type, Pokemon evolution, List<PokemonTrainer> trainersThatOwn) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
		this.evolution = evolution;
		this.trainersThatOwn = trainersThatOwn;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

	public Pokemon getEvolution() {
		return evolution;
	}

	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}
	
	public List<PokemonTrainer> getTrainersThatOwn() {
		return trainersThatOwn;
	}

	public void setTrainersThatOwn(List<PokemonTrainer> trainersThatOwn) {
		this.trainersThatOwn = trainersThatOwn;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", number=" + number + ", type=" + type + ", evolution="
				+ evolution + "]";
	}
}

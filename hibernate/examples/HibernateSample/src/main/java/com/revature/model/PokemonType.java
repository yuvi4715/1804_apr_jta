package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="POKEMON_TYPE",
uniqueConstraints = { @UniqueConstraint( columnNames = { "PT_NAME"} ) })
public class PokemonType {
	
	@Id
	@GeneratedValue
	@Column(name="PT_ID")
	private int id;
	
	@Column(name="PT_NAME")
	private String name;
	
	public PokemonType() {}
	
	public PokemonType(String name) {
		this.name = name.toUpperCase();
	}

	public PokemonType(int id, String name) {
		this.id = id;
		this.name = name.toUpperCase();
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

	@Override
	public String toString() {
		return "PokemonType [id=" + id + ", name=" + name + "]";
	}
}

package com.revature.model;

import java.io.Serializable;

public class Pokemon implements Serializable {

	private static final long serialVersionUID = 1L;
	private int pokedexEntry;
	private String name;
	private String primaryType;
	private String secondaryType;
	private int generation;
	
	public Pokemon() {}

	public Pokemon(int pokedexEntry, String name, String primaryType, String secondaryType, int generation) {
		super();
		this.pokedexEntry = pokedexEntry;
		this.name = name;
		this.primaryType = primaryType;
		this.setSecondaryType(secondaryType);
		this.generation = generation;
	}

	public int getPokedexEntry() {
		return pokedexEntry;
	}

	public void setPokedexEntry(int pokedexEntry) {
		this.pokedexEntry = pokedexEntry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryType() {
		return primaryType;
	}

	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}

	public String getSecondaryType() {
		return secondaryType;
	}

	public void setSecondaryType(String secondaryType) {
		if (secondaryType == null) {
			this.secondaryType = "N/A";
		}
		this.secondaryType = secondaryType;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + generation;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pokedexEntry;
		result = prime * result + ((primaryType == null) ? 0 : primaryType.hashCode());
		result = prime * result + ((secondaryType == null) ? 0 : secondaryType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (generation != other.generation)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokedexEntry != other.pokedexEntry)
			return false;
		if (primaryType == null) {
			if (other.primaryType != null)
				return false;
		} else if (!primaryType.equals(other.primaryType))
			return false;
		if (secondaryType == null) {
			if (other.secondaryType != null)
				return false;
		} else if (!secondaryType.equals(other.secondaryType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [pokedexEntry=" + pokedexEntry + ", name=" + name + ", primaryType=" + primaryType
				+ ", secondaryType=" + secondaryType + ", generation=" + generation + "]";
	}
}

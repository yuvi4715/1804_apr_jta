package com.revature.model;

import java.io.Serializable;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1l;

    private int pokedexEntry;
    private String name;
    private String primaryType;
    private String secondaryType;
    private int generation;

    public Pokemon(){}
    public Pokemon(int poke, String name1, String type1, String type2, int gen){
        super();
        this.pokedexEntry = poke;
        this.name = name1;
        this.primaryType = type1;
        this.secondaryType = type2;
        this.generation = gen;

    }


    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
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
        this.secondaryType = secondaryType;
    }

    public int getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

}

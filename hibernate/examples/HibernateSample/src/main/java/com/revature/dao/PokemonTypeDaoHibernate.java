package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Session;

import com.revature.model.PokemonType;
import com.revature.util.ConnectionUtil;

public class PokemonTypeDaoHibernate implements PokemonTypeDao {
	
	@Override
	public void insert(PokemonType pokemonType) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		session.save(pokemonType);
		session.getTransaction().commit();
	}

	@Override
	public PokemonType selectByName(PokemonType pokemonType) {
		try {
		return (PokemonType) ConnectionUtil.getSession()
				.createCriteria(PokemonType.class)
				.add(eq("name", pokemonType.getName()))
				.list()
				.get(0);
		} catch (IndexOutOfBoundsException e) {
			return new PokemonType();
		}
	}

}

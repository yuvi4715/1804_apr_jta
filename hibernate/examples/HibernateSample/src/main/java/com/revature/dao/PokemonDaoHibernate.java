package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;
import com.revature.util.ConnectionUtil;

public class PokemonDaoHibernate implements PokemonDao {

	/* Insert a pokemon */
	@Override
	public void insert(Pokemon pokemon) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		session.save(pokemon);
		session.getTransaction().commit();
	}

	/* Get all pokemon */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> selectAll() {
		return ConnectionUtil.getSession().createCriteria(Pokemon.class).list();
	}

	/* Get pokemon by name */
	@Override
	public Pokemon selectByName(Pokemon pokemon) {
		try{
			return (Pokemon) ConnectionUtil.getSession()
					.createCriteria(Pokemon.class)
					.add(eq("name", pokemon.getName().toUpperCase()))
					.list()
					.get(0);
		} catch(IndexOutOfBoundsException e) {		
			return new Pokemon();
		}
	}
	
	/* Get pokemon by type */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> selectByType(PokemonType pokemonType) {
		return ConnectionUtil.getSession()
				.createCriteria(Pokemon.class)
				.add(eq("type", pokemonType))
				.list();
	}
	
	/* Get pokemon with HQL */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pokemon> selectByNameCriteria(String criteria) {
		String hql = "FROM com.revature.model.Pokemon WHERE name like :criteria";
		return ConnectionUtil.getSession()
				.createQuery(hql)
				.setString("criteria", criteria)
				.list();
	}
}

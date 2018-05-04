package com.revature.dao;

import static org.hibernate.criterion.Restrictions.eq;

import org.hibernate.Session;

import com.revature.model.PokemonTrainer;
import com.revature.util.ConnectionUtil;

public class PokemonTrainerDaoHibernate implements PokemonTrainerDao {

	@Override
	public void insert(PokemonTrainer pokemonTrainer) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		session.save(pokemonTrainer);
		session.getTransaction().commit();
	}

	@Override
	public PokemonTrainer selectByName(PokemonTrainer pokemonTrainer) {
		try{
			return (PokemonTrainer) ConnectionUtil.getSession()
					.createCriteria(PokemonTrainer.class)
					.add(eq("name", pokemonTrainer.getName().toUpperCase()))
					.list()
					.get(0);
		} catch(IndexOutOfBoundsException e) {		
			return new PokemonTrainer();
		}
	}

	/* Update trainer information (mainly used for pokemons owened)
	 * NOTICE: the only difference of update is "saveOrUpdate".
	 */
	@Override
	public void update(PokemonTrainer pokemonTrainer) {
		Session session = ConnectionUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(pokemonTrainer);
		session.getTransaction().commit();
	}
}

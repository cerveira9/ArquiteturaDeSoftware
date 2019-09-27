package com.fsma.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fsma.arquitetura.model.Uf;

public class DaoUf {
	
	private EntityManager em;

	public DaoUf(EntityManager em) {
		this.em = em;
	}

	public Uf buscaPorNome(String nome) {
		
		try {
			String jpql = "select u from Uf u where u.nome = :nome";
			TypedQuery<Uf> query = em.createQuery(jpql, Uf.class);
			query.setParameter("nome", nome);
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void inserir(Uf uf) {
		em.persist(uf);
		
	}
	
	
	
}

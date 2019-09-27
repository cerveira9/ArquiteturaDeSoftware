package com.fsma.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Uf;

public class DaoCidade {

	private EntityManager em;

	public DaoCidade(EntityManager em) {
		this.em = em;
	}
	
	public Cidade buscaCidadePorNomeEUf(String nome, Uf uf) {
		
		try {
			String jpql = "select c from Cidade c where c.nome = :nome and c.uf=:uf";
			TypedQuery<Cidade> query = em.createQuery(jpql, Cidade.class);
			query.setParameter("nome", nome);
			query.setParameter("uf", uf);
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void inserir(Cidade cidade) {
		em.persist(cidade);
		
	}

}

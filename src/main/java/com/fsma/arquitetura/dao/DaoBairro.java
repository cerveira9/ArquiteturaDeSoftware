package com.fsma.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fsma.arquitetura.model.Bairro;
import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Uf;

public class DaoBairro {
	private EntityManager em;

	public DaoBairro(EntityManager em) {
		this.em = em;
	}
	
	public Bairro buscaBairroPorNomeECidadeEUf(String nome, Cidade cidade, Uf uf) {
		
		try {
			String jpql = "select b from Bairro b where b.nome = :nome and b.uf=:uf and b.cidade=:cidade";
			TypedQuery<Bairro> query = em.createQuery(jpql, Bairro.class);
			query.setParameter("nome", nome);
			query.setParameter("uf", uf);
			query.setParameter("cidade", cidade);
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void inserir(Bairro bairro) {
		em.persist(bairro);
		
	}
}

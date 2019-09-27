package com.fsma.arquitetura.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fsma.arquitetura.model.Empresa;

public class DaoEmpresa {
	private EntityManager em;

	public DaoEmpresa(EntityManager em) {
		this.em = em;
	}

	public Empresa buscaEmpresaPorCnpj(String cnpj) {
		try {
			String jpql = "select e from Empresa e where e.cnpj = :cnpj";
			TypedQuery<Empresa> query = em.createQuery(jpql, Empresa.class);
			query.setParameter("cnpj", cnpj);
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void inserir(Empresa empresa) {
		em.persist(empresa);
		
	}

	public void update(Empresa empresa) {
		em.merge(empresa);
	}
}

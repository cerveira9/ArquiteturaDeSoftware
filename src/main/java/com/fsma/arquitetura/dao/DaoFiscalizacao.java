package com.fsma.arquitetura.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fsma.arquitetura.model.Fiscalizacao;

public class DaoFiscalizacao {
	private EntityManager em;

	public DaoFiscalizacao(EntityManager em) {
		this.em = em;
	}

	public Fiscalizacao buscaFsicalizacaoPorCnpjEPorData(String cnpj, LocalDate data) {
		try {
			String jpql = "select f from Fiscalizacao f where f.cnpj = :cnpj and f.dataUltimaFiscalizacao = :data";
			TypedQuery<Fiscalizacao> query = em.createQuery(jpql, Fiscalizacao.class);
			query.setParameter("cnpj", cnpj);
			query.setParameter("data", data);
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void inserir(Fiscalizacao fiscalizacao) {
		em.persist(fiscalizacao);
		
	}
}

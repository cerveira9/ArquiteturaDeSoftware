package com.fsma.arquitetura.processador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.processador.Processador;

public class ProcessadorLinha implements Processador {

	private List<Processador> processadores = new ArrayList<>();

	private EntityManager em;

	public ProcessadorLinha(EntityManager em) {
		processadores.add(new EstadoProcessador(em));
		processadores.add(new CidadeProcessador(em));
		processadores.add(new BairroProcessador(em));
		processadores.add(new EmpresaProcessador(em));
		processadores.add(new FiscalizacaoProcessador(em));
		this.em = em;
	}

	@Override
	public void processa(String linha) {
		try {
			em.getTransaction().begin();
			for (Processador processador : processadores) {
				processador.processa(linha);			
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} 
	}

}

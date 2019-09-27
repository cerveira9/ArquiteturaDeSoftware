package com.fsma.arquitetura.processador;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.dao.DaoCidade;
import com.fsma.arquitetura.dao.DaoUf;
import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Uf;

public class CidadeProcessador implements Processador {

	private DaoCidade daoCidade;
	private DaoUf daoUf;

	public CidadeProcessador(EntityManager em) {
		daoCidade = new DaoCidade(em);
		daoUf = new DaoUf(em);
	}

	@Override
	public void processa(String linha) {
		
		FiscalizacaoCsv fiscalizacaoCsv = new FiscalizacaoCsv(linha);
		
		if (!fiscalizacaoCsv.isValid()) {
			return;
		}
		
		Uf uf = daoUf.buscaPorNome(fiscalizacaoCsv.getNomeUf());
		
		Cidade cidade = daoCidade.buscaCidadePorNomeEUf(fiscalizacaoCsv.getCidade(), uf);
		
		if (cidade != null) {
			return;
		}
		
		cidade = criarCidade(fiscalizacaoCsv, uf);
		
		daoCidade.inserir(cidade);
	}

	private Cidade criarCidade(FiscalizacaoCsv fiscalizacaoCsv, Uf uf) {
		String nome = fiscalizacaoCsv.getCidade();
		return new Cidade(nome, uf);
	}

}

package com.fsma.arquitetura.processador;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.dao.DaoBairro;
import com.fsma.arquitetura.dao.DaoCidade;
import com.fsma.arquitetura.dao.DaoUf;
import com.fsma.arquitetura.model.Bairro;
import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Uf;

public class BairroProcessador implements Processador{

	private DaoBairro daoBairro;
	private DaoCidade daoCidade;
	private DaoUf daoUf;

	public BairroProcessador(EntityManager em) {
		daoBairro = new DaoBairro(em);
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
		
		Bairro bairro = daoBairro.buscaBairroPorNomeECidadeEUf(fiscalizacaoCsv.getBairro(), cidade, uf);
		
		if (bairro != null) {
			return;
		}
		
		bairro = criarBairro(fiscalizacaoCsv, uf, cidade);
		
		daoBairro.inserir(bairro);
		
		
		
	}

	private Bairro criarBairro(FiscalizacaoCsv fiscalizacaoCsv, Uf uf, Cidade cidade) {
		String nome = fiscalizacaoCsv.getBairro();
		return new Bairro(nome, cidade, uf);
	}

}

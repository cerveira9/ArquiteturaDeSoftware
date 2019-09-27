package com.fsma.arquitetura.processador;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.dao.DaoUf;
import com.fsma.arquitetura.model.Uf;

public class EstadoProcessador implements Processador{

	private DaoUf daoUf;

	public EstadoProcessador(EntityManager em) {
		daoUf = new DaoUf(em);
	}

	@Override
	public void processa(String linha) {
		
		FiscalizacaoCsv fiscalizacaoCsv = new FiscalizacaoCsv(linha);
		
		if (!fiscalizacaoCsv.isValid()) {
			return;
		}
		
		
		Uf uf = daoUf.buscaPorNome(fiscalizacaoCsv.getNomeUf());
		
		if (uf != null) {
			return;
		}
		uf = criarUf(fiscalizacaoCsv);
		
		daoUf.inserir(uf);

	}

	private Uf criarUf(FiscalizacaoCsv csv) {
		String nome = csv.getNomeUf(); 
		String sigla = getSigla(nome);
		return new Uf(nome,sigla);
	}

	private String getSigla(String nome) {
		switch (nome) {
		case "ACRE":
			return "AC";
		case "ALAGOAS":
			return "AL";
		case "AMAZONAS":
			return "AM";
		case "BAHIA":
			return "BA";
		case "CEARÁ":
			return "CE";
		case "BRASÍLIA":
		case "DISTRITO FEDERAL":
			return "DF";
		case "ESPÍRITO SANTO":
			return "ES";
		case "GOIÁS":
			return "GO";
		case "MARANHÃO":
			return "MA";
		case "MATO GROSSO":
			return "MT";
		case "MATO GROSSO DO SUL":
			return "MS";
		case "MINAS GERAIS":
			return "MG";
		case "PARÁ":
			return "PA";
		case "PARAÍBA":
			return "PB";
		case "PARANÁ":
			return "PR";
		case "PERNAMBUCO":
			return "PE";
		case "PIAUÍ":
			return "PI";
		case "RIO DE JANEIRO":
			return "RJ";
		case "RIO GRANDE DO NORTE":
			return "RN";
		case "RIO GRANDE DO SUL":
			return "RS";
		case "RONDÔNIA":
			return "RO";
		case "RORAIMA":
			return "RR";
		case "SANTA CATARINA":
			return "SC";
		case "SÃO PAULO":
			return "SP";
		case "SERGIPE":
			return "SE";
		case "TOCANTINS":
			return "TO";
		default:
			return "N/A";
		}

	}

}

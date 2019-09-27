package com.fsma.arquitetura.processador;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.dao.CnpjValidador;
import com.fsma.arquitetura.dao.DaoBairro;
import com.fsma.arquitetura.dao.DaoCidade;
import com.fsma.arquitetura.dao.DaoEmpresa;
import com.fsma.arquitetura.dao.DaoUf;
import com.fsma.arquitetura.model.Bairro;
import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Empresa;
import com.fsma.arquitetura.model.Uf;
import com.fsma.arquitetura.servico.DataConverter;

public class EmpresaProcessador implements Processador {

	private DaoUf daoUf;
	private DaoCidade daoCidade;
	private DaoBairro daoBairro;
	private DaoEmpresa daoEmpresa;

	public EmpresaProcessador(EntityManager em) {
		daoBairro = new DaoBairro(em);
		daoCidade = new DaoCidade(em);
		daoUf = new DaoUf(em);
		daoEmpresa = new DaoEmpresa(em);
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
		
		String cnpj = fiscalizacaoCsv.getCnpj();
		String data = fiscalizacaoCsv.getUltimaFiscalizacao();
		
		DataConverter dataConverter = new DataConverter();
		
		LocalDate dataConvertida = dataConverter.converterAData(data);
		
		if (!CnpjValidador.isValid(cnpj)) {
			return;
		}
		
		Empresa empresa = daoEmpresa.buscaEmpresaPorCnpj(cnpj);
		
		if (empresa != null) {
			return;
		}
		
		empresa = criarEmpresa(fiscalizacaoCsv, bairro, cidade, uf, cnpj, dataConvertida);
		
		daoEmpresa.inserir(empresa);
	}

	private Empresa criarEmpresa(FiscalizacaoCsv fiscalizacaoCsv, Bairro bairro, Cidade cidade, Uf uf, String cnpj, LocalDate dataUltimaFiscalizacao) {
		String razaoSocial = fiscalizacaoCsv.getRazaoSocial();
		String logradouro = fiscalizacaoCsv.getLogradouro();
		String cep = fiscalizacaoCsv.getCep();
		return new Empresa(razaoSocial, logradouro, cep, cnpj, bairro, cidade, uf, dataUltimaFiscalizacao);
	}

	

}

package com.fsma.arquitetura.processador;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.fsma.arquitetura.dao.CnpjValidador;
import com.fsma.arquitetura.dao.DaoBairro;
import com.fsma.arquitetura.dao.DaoCidade;
import com.fsma.arquitetura.dao.DaoEmpresa;
import com.fsma.arquitetura.dao.DaoFiscalizacao;
import com.fsma.arquitetura.dao.DaoUf;
import com.fsma.arquitetura.model.Bairro;
import com.fsma.arquitetura.model.Cidade;
import com.fsma.arquitetura.model.Empresa;
import com.fsma.arquitetura.model.Fiscalizacao;
import com.fsma.arquitetura.model.Uf;
import com.fsma.arquitetura.servico.DataConverter;

public class FiscalizacaoProcessador implements Processador {
	
	private DaoBairro daoBairro;
	private DaoCidade daoCidade;
	private DaoUf daoUf;
	private DaoEmpresa daoEmpresa;
	private DaoFiscalizacao daoFiscalizacao;
	
	public FiscalizacaoProcessador(EntityManager em) {
		daoBairro = new DaoBairro(em);
		daoCidade = new DaoCidade(em);
		daoUf = new DaoUf(em);
		daoEmpresa = new DaoEmpresa(em);
		daoFiscalizacao = new DaoFiscalizacao(em);
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
		
		Fiscalizacao fiscalizacao = daoFiscalizacao.buscaFsicalizacaoPorCnpjEPorData(cnpj, dataConvertida);
		
		if (fiscalizacao != null) {
			return;
		}
		
		fiscalizacao = criarFiscalizacao(fiscalizacaoCsv, bairro, cidade, uf, cnpj, dataConvertida, empresa);
		
		daoFiscalizacao.inserir(fiscalizacao);
		atualizaEmpresa(fiscalizacaoCsv, bairro, cidade, uf, cnpj, dataConvertida, empresa);
		
	}

	private void atualizaEmpresa(FiscalizacaoCsv fiscalizacaoCsv, Bairro bairro, Cidade cidade, Uf uf, String cnpj, LocalDate dataConvertida, Empresa empresa) {
		if (empresa.getDataUltimaFiscalizacao().isBefore(dataConvertida)) {
			empresa.setUf(uf);
			empresa.setCidade(cidade);
			empresa.setBairro(bairro);
			empresa.setCep(fiscalizacaoCsv.getCep());
			empresa.setLogradouro(fiscalizacaoCsv.getLogradouro());
			empresa.setRazaoSocial(fiscalizacaoCsv.getRazaoSocial());
			empresa.setDataUltimaFiscalizacao(dataConvertida);
			daoEmpresa.update(empresa);
		}
	}

	private Fiscalizacao criarFiscalizacao(FiscalizacaoCsv fiscalizacaoCsv, Bairro bairro, Cidade cidade, Uf uf,
			String cnpj, LocalDate dataConvertida, Empresa empresa) {
		String razaoSocial = fiscalizacaoCsv.getRazaoSocial();
		String logradouro = fiscalizacaoCsv.getLogradouro();
		return new Fiscalizacao(razaoSocial, logradouro, cnpj, bairro, cidade, uf, dataConvertida, empresa);
	}

	

}

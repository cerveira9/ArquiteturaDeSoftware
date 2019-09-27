package com.fsma.arquitetura.processador;

import com.fsma.arquitetura.dao.CnpjValidador;

public class CnpjProcessador implements Processador{

	@Override
	public void processa(String linha) {

		FiscalizacaoCsv fiscalizacaoCsv = new FiscalizacaoCsv(linha);
		
		if (fiscalizacaoCsv.isValid() || CnpjValidador.isValid(fiscalizacaoCsv.getCnpj())) {
			System.out.println(fiscalizacaoCsv.getCnpj()); 
		}
		
	}

}

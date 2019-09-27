package com.fsma.arquitetura.processador;

public class LogradouroProcessador implements Processador {

	@Override
	public void processa(String linha) {

		FiscalizacaoCsv fiscalizacaoCsv = new FiscalizacaoCsv(linha);
		
		if (fiscalizacaoCsv.isValid()) {
			System.out.println(fiscalizacaoCsv.getLogradouro()); 
		}
	}

}

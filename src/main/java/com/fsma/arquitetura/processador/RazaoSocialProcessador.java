package com.fsma.arquitetura.processador;

public class RazaoSocialProcessador implements Processador{

	@Override
	public void processa(String linha) {
		
		FiscalizacaoCsv fiscalizacaoCsv = new FiscalizacaoCsv(linha);
		
		if (fiscalizacaoCsv.isValid()) {
			System.out.println(fiscalizacaoCsv.getRazaoSocial()); 
		}
		
	}

}

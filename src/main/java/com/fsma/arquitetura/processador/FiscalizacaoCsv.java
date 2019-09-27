package com.fsma.arquitetura.processador;

public class FiscalizacaoCsv {
	
	private String campos[];

	public FiscalizacaoCsv(String linha) {
		if (linha != null) { 
			campos = linha.split(";");
		}
	}
	
	public String getUltimaFiscalizacao() {
		return campos[1];
	}

	public String getCnpj() {
		return campos[2];
	}

	public String getRazaoSocial() {
		return campos[3];
	}

	public String getLogradouro() {
		return campos[4];
	}
	
	public String getCep() {
		return campos[5];
	}
	
	public String getBairro() {
		return campos[6];
	}

	public String getCidade() {
		return campos[7];
	}

	public String getNomeUf() {
		return campos[8].toUpperCase();
	}

	public boolean isValid() {
		return  (campos != null) && (campos.length == 9);
	}

	public int getQuantidadeColunas() {
		return campos.length;
	}

	

}

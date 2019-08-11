package com.fsma.arquitetura.arquivo;

public class AnalizadorDeTexto {
	
	private String stringAnalizada;
	private int tamanhoDaString;
	private int quantidadeDeVogais;
	private int quantidadeDeEspacosBrancos;
	private int quantidadeDeConsoantes;
	
	
	public AnalizadorDeTexto(String stringAnalizada) {
		super();
		this.stringAnalizada = stringAnalizada;
	}
	public String getStringAnalizada() {
		return stringAnalizada;
	}

	public int getTamanhoDaString() {
		return tamanhoDaString;
	}

	public int getQuantidadeDeVogais() {
		return quantidadeDeVogais;
	}

	public int getQuantidadeDeEspacosBrancos() {
		return quantidadeDeEspacosBrancos;
	}

	public int getQuantidadeDeConsoantes() {
		return quantidadeDeConsoantes;
	}

	
	
}

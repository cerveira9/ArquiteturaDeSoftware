package com.fsma.arquitetura.arquivo;

public class AnalizadorDeTexto {
	
	private String stringAnalizada;
	private int tamanhoDaString;
	private int quantidadeDeVogais;
	private int quantidadeDeEspacosBrancos;
	private int quantidadeDeConsoantes;
	
	
	public AnalizadorDeTexto(String stringAnalizada) {
		super();
		this.setStringAnalizada(stringAnalizada);
	}

	public String getTamanhoDaString() {
		this.tamanhoDaString = this.stringAnalizada.length();
		return "Tamanho da String: " + tamanhoDaString;
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

	public String getStringAnalizada() {
		return stringAnalizada;
	}

	public void setStringAnalizada(String stringAnalizada) {
		this.stringAnalizada = stringAnalizada;
	}

	
}

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

	public void getTamanhoDaString() {
		this.tamanhoDaString = this.stringAnalizada.length();
		System.out.println("Tamanho da String: " + quantidadeDeVogais);
	}

	public void getQuantidadeDeVogais() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				quantidadeDeVogais++;	
		}
		System.out.println("Quantidade de vogais: " + quantidadeDeVogais);
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

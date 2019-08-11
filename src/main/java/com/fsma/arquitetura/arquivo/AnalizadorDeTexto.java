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

	public void getQuantidadeDeEspacosBrancos() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'v' || c == 'w' || c == 'x' || c == 'y' || c == 'z')
				quantidadeDeVogais++;	
		}
		System.out.println("Quantidade de espaços brancos: " + quantidadeDeEspacosBrancos);
	}

	public void getQuantidadeDeConsoantes() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == ' ')
				quantidadeDeVogais++;	
		}
		System.out.println("Quantidade de consoantes: " + quantidadeDeConsoantes);
	}

	public String getStringAnalizada() {
		return stringAnalizada;
	}

	public void setStringAnalizada(String stringAnalizada) {
		this.stringAnalizada = stringAnalizada;
	}

}

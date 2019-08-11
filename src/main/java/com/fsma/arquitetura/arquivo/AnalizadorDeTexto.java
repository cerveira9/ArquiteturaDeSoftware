package com.fsma.arquitetura.arquivo;

public class AnalizadorDeTexto {

	private String stringAnalizada;
	private int quantidadeDeVogais;
	private int quantidadeDeEspacosBrancos;
	private int quantidadeDeConsoantes;

	public AnalizadorDeTexto(String stringAnalizada) {
		this.setStringAnalizada(stringAnalizada.toLowerCase());
		System.out.println("String Analizada: " + this.stringAnalizada);
	}

	public void getTamanhoDaString() {
		System.out.println("Tamanho da String: " + this.stringAnalizada.length());
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
			if (c == ' ')
				quantidadeDeEspacosBrancos++;
		}
		System.out.println("Quantidade de espaços brancos: " + quantidadeDeEspacosBrancos);
	}

	public void getQuantidadeDeConsoantes() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l'
					|| c == 'm' || c == 'n' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'v'
					|| c == 'w' || c == 'x' || c == 'y' || c == 'z')
				quantidadeDeConsoantes++;
		}
		System.out.println("Quantidade de consoantes: " + quantidadeDeConsoantes);
	}


	public void setStringAnalizada(String stringAnalizada) {
		this.stringAnalizada = stringAnalizada;
	}

}

package com.fsma.arquitetura.arquivo;

public class AnalisadorLinha {

	private String stringAnalizada;
	private int quantidadeVogais;
	private int quantidadeEspacosBrancos;
	private int quantidadeConsoantes;

	public AnalisadorLinha(String stringAnalizada) {
		this.setStringAnalizada(stringAnalizada.toLowerCase());
		System.out.println("String Analizada: " + this.stringAnalizada);
	}

	public void setStringAnalizada(String stringAnalizada) {
		this.stringAnalizada = stringAnalizada;
	}
	
	public int getTamanhoDaString() {
		return this.stringAnalizada.length();
	}

	public int getQuantidadeDeVogais() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				quantidadeVogais++;
		}
		return quantidadeVogais;
	}

	public int getQuantidadeDeEspacosBrancos() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == ' ')
				quantidadeEspacosBrancos++;
		}
		return quantidadeEspacosBrancos;
	}

	public int getQuantidadeDeConsoantes() {
		for (int i = 0; i < this.stringAnalizada.length(); i++) {
			char c = this.stringAnalizada.charAt(i);
			if (c == 'b' || c == 'c' || c == 'd' || c == 'f' || c == 'g' || c == 'h' || c == 'j' || c == 'k' || c == 'l'
					|| c == 'm' || c == 'n' || c == 'p' || c == 'q' || c == 'r' || c == 's' || c == 't' || c == 'v'
					|| c == 'w' || c == 'x' || c == 'y' || c == 'z')
				quantidadeConsoantes++;
		}
		return quantidadeConsoantes;
	}
}

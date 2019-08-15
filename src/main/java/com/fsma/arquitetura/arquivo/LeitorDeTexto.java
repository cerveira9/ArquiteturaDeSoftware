package com.fsma.arquitetura.arquivo;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeitorDeTexto {

	private String caminhoDoArquivo;

	public LeitorDeTexto(String caminhoDoArquivo) {
		super();
		this.setCaminhoDoArquivo(caminhoDoArquivo);

	}

	public String getCaminhoDoArquivo() {
		return caminhoDoArquivo;
	}

	public void setCaminhoDoArquivo(String caminhoDoArquivo) {
		this.caminhoDoArquivo = caminhoDoArquivo;
	}

	public void imprimirLinhas() throws IOException {
		Scanner scanner = new Scanner(new FileReader(this.caminhoDoArquivo));
		scanner.useDelimiter("\\n");
        while (scanner.hasNext()) {
        	String linha = scanner.next();
			AnalisadorLinha analizadorDeTexto = new AnalisadorLinha(linha);
			System.out.println("Tamanho da String: " + analizadorDeTexto.getTamanhoDaString());
			System.out.println("Quantidade de Vogais da String: " + analizadorDeTexto.getQuantidadeDeVogais());
			System.out.println("Quantidade de Espaços Brancos da String: " + analizadorDeTexto.getQuantidadeDeEspacosBrancos());
			System.out.println("Quantidade de Consoantes da String: " + analizadorDeTexto.getQuantidadeDeConsoantes());
        }
        scanner.close();

	}

}

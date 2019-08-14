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

	public void lerArquivo() throws IOException {
		Scanner scanner = new Scanner(new FileReader(this.caminhoDoArquivo));
		scanner.useDelimiter("\\n");
        while (scanner.hasNext()) {
        	String linha = scanner.next();
			AnalizadorDeTexto analizadorDeTexto = new AnalizadorDeTexto(linha);
			analizadorDeTexto.getTamanhoDaString();
			analizadorDeTexto.getQuantidadeDeVogais();
			analizadorDeTexto.getQuantidadeDeEspacosBrancos();
			analizadorDeTexto.getQuantidadeDeConsoantes();
        }
        scanner.close();

	}

}

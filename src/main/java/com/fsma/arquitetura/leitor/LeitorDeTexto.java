package com.fsma.arquitetura.leitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
		Path path = Paths.get(this.caminhoDoArquivo);

		List<String> linhasArquivo = Files.readAllLines(path);
		for (String linha : linhasArquivo) {
			System.out.println(linha);
		}

	}

}

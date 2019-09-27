package com.fsma.arquitetura.arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fsma.arquitetura.processador.Processador;

public class LeitorTexto {

	public LeitorTexto() {
	}

	public void lerLinhas(String caminhoDoArquivo, Processador processador) throws IOException {
		try {
			String linha;
			BufferedReader csv = new BufferedReader(new FileReader(caminhoDoArquivo));
			linha = csv.readLine();
			while ((linha = csv.readLine()) != null) {
				processador.processa(linha);				
			}

			csv.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n" + e.getMessage());
		}
	}

}

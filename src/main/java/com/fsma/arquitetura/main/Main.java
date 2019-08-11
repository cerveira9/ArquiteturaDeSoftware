package com.fsma.arquitetura.main;

import java.io.IOException;

import com.fsma.arquitetura.leitor.LeitorDeTexto;

public class Main {

	public static void main(String[] args) throws IOException {
		LeitorDeTexto leitorDeTexto = new LeitorDeTexto("/Users/fernandocerveira/Documents/AI/darknet/arq.txt");
		leitorDeTexto.lerArquivo();
	}
}

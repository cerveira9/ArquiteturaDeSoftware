package com.fsma.arquitetura.main;

import java.io.IOException;

import com.fsma.arquitetura.arquivo.LeitorDeTexto;

public class Main {

	public static void main(String[] args) throws IOException {
		LeitorDeTexto leitorDeTexto = new LeitorDeTexto("arquivoDeExemplo.txt");
		leitorDeTexto.imprimirLinhas();
	}
}
